public class EncodeFloat {

    // Encodes a floating point to binary IEEE 754 with
    // Bits = 16, 32 or 64.
    // Doesn't support floats less than 1.
    public static String toString(double x, int size) {
        int signBit = 1;
        if (x >= 0.0) signBit = 0;

        int precision = 1;
        int expBits   = 1;
        int offset    = 1;
        if (size >> 4 == 1) { precision = 10; expBits =  5; offset =   15; }
        if (size >> 5 == 1) { precision = 23; expBits =  8; offset =  127; }
        if (size >> 6 == 1) { precision = 52; expBits = 11; offset = 1023; }

        x = Math.abs(x);
        int exponent = (int) (Math.log(x)/Math.log(2)) + offset;
        double mantissa = x/Math.pow(2, exponent-offset);

        String s = Integer.toString(exponent, 2);
        while (s.length() < expBits) s = "0" + s;

        s = signBit + s + toString(mantissa-1, "", precision);
        while (s.length() < size) s += "0";
        return s;
    }

    // Decodes binary IEEE 754 floating point with
    // Bits = 16, 32 or 64.
    public static double toFloat(String flt, int size) {
        int sign = 1;
        if (flt.charAt(0) == '1') sign = -1;

        int offsetBits = 1, offset = 1;
        if (size >> 4 == 1) { offsetBits =  5; offset =   15; }
        if (size >> 5 == 1) { offsetBits =  8; offset =  127; }
        if (size >> 6 == 1) { offsetBits = 11; offset = 1023; }

        int fractionBits = size - offsetBits - 1;
        int exponent = Integer.parseInt(flt.substring(1, offsetBits+1), 2) - offset;
        double mantissa = 1.0;
        for (int i = offsetBits+1; i < flt.length(); i++)
            if (flt.charAt(i) == '1')
                mantissa += 1.0/Math.pow(2, i-offsetBits);

        return sign * Math.pow(2, exponent) * mantissa;
    }
    public static String toString(double x, String s, int precision) {
        if (x == 0 || s.length() == precision) return s;
        if (2*x < 1.0) return toString(2*x, s + "0", precision);
        return toString(2*x - 1, s + "1", precision);
    }
    public static void main(String[] args) {
        Double x = Double.parseDouble(args[0]);
        int size = Integer.parseInt(args[1]);

        if      (size == 64) {
            StdOut.println("IEEE 754 Binary64 Encoding.");
            ExtractDouble.show(x);
            StdOut.println();
        }
        else if (size == 32) {
            StdOut.println("IEEE 754 Binary32 Encoding: " + x);
            ExtractFloat.show((float)((double)x));
            StdOut.println();
        }

        StdOut.printf("%-13s %f\n", "Real number ", x);
        StdOut.printf("%-6s%-7d %s\n", "binary", size, toString(x, size));
        StdOut.printf("%-13s %f\n", "Back to real", toFloat(toString(x, size), size));
    }
}

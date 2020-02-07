public class ExtractDouble {
    public static void main(String[] args) {
        Double x = Double.parseDouble(args[0]);

        show(x);
    }
    public static void show(Double x) {
        long bits = Double.doubleToLongBits(x);
        long signBit      = (bits >> 63) & 0x0000000000001L;
        long exponentBits = (bits >> 52) & 0x00000000007FFL;
        long fractionBits = (bits >>  0) & 0xFFFFFFFFFFFFFL;

        long exponent = exponentBits - 1023;
        double fraction = 1.0 * fractionBits / (1L << 52);
        double mantissa = 1.0 + fraction;

        if (signBit == 1) StdOut.printf("%-13s %s\n", "Sign", "-");
        else              StdOut.printf("%-13s %s\n", "Sign", "+");

        StdOut.printf("%-13s %d\n", "Exponent", exponent);
        StdOut.printf("%-13s %f\n", "Mantissa", mantissa);
        StdOut.printf("%-13s %f\n", "Fraction", fraction);
    }
}

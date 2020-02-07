public class ExtractFloat {
    public static void main(String[] args) {
        Float x = Float.parseFloat(args[0]);
        show(x);
    }
    public static void show(Float x) {
       int bits = Float.floatToIntBits(x);
       int signBit      = (bits >> 31) & 0x00000001;
       int exponentBits = (bits >> 23) & 0x000000FF;
       int fractionBits = (bits >>  0) & 0x007FFFFF;

       int exponent = exponentBits - 127;
       double fraction = 1.0 * fractionBits / (1 << 23);
       double mantissa = 1.0 + fraction;


       if (signBit == 1) StdOut.printf("%-13s %s\n", "Sign", "-");
       else              StdOut.printf("%-13s %s\n", "Sign", "+");

       StdOut.printf("%-13s %d\n", "Exponent", exponent);
       StdOut.printf("%-13s %f\n", "Mantissa", mantissa);
       StdOut.printf("%-13s %f\n", "Fraction", fraction);
   }
}

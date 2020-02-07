public class FloatingPoint {
    private int sign;
    private long exponent;
    private double fraction;

    public FloatingPoint() {}
    public FloatingPoint(double x) {
        int bits = Float.floatToIntBits((float)x);
        int signBit      = (bits >> 31) & 0x00000001;
        int exponentBits = (bits >> 23) & 0x000000FF;
        int fractionBits = (bits >>  0) & 0x007FFFFF;

        sign   = signBit == 1? -1: +1;
        exponent = exponentBits - 127;
        fraction = 1.0 * fractionBits / (1 << 23);
    }
    public FloatingPoint add(FloatingPoint that) {
        FloatingPoint sum = new FloatingPoint();
        sum.sign = this.sign ^ that.sign;
        sum.exponent = this.exponent + that.exponent;
        sum.fraction = this.fraction * that.fraction;
        if (sum.fraction >= 1.0) {
            int twos = (int)(Math.log(sum.fraction)/Math.log(2));
            sum.exponent += twos;
            sum.fraction -= twos;
        }
        return sum;
    }
    public String toString() {
        return (sign == -1? "-": "+") +
               "2^" + exponent + " x " + (1.0 + fraction);
    }
    public FloatingPoint normalize(FloatingPoint fp) {
        double x = fp.sign * (1 << fp.exponent) * (1.0 + fp.fraction);
        return new FloatingPoint(x);
    }
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        FloatingPoint fx = new FloatingPoint(x);
        FloatingPoint fy = new FloatingPoint(y);

        StdOut.println(fx);
        StdOut.println(fy);
        //ExtractFloat.show((Float)((float)x));
        //ExtractFloat.show((Float)((float)y));

        StdOut.println(fx.add(fy));
    }
}

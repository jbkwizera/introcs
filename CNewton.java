public class CNewton {
    public static double[] mul(double[] u, double[] v) {
        double re = u[0]*v[0] - u[1]*v[1];
        double im = u[0]*v[1] + u[1]*v[0];
        return new double[]{re, im};
    }
    public static double[] div(double[] u, double[] v) {
        double re = (u[0]*v[0] + u[1]*v[1])/(v[0]*v[0] + v[1]*v[1]);
        double im = (u[1]*v[0] - u[0]*v[1])/(v[0]*v[0] + v[1]*v[1]);
        return new double[]{re, im};
    }
    public static double[] add(double[] u, double[] v) {
        double re = u[0] + v[0];
        double im = u[1] + v[1];
        return new double[]{re, im};
    }
    public static double[] sub(double[] u, double[] v) {
        double re = u[0] - v[0];
        double im = u[1] - v[1];
        return new double[]{re, im};
    }
    public static double[] sca(double[] z, double c) {
        return new double[]{c*z[0], c*z[1]};
    }
    public static double mag(double[] z) {
        return Math.sqrt(z[0]*z[0] + z[1]*z[1]);
    }
    public static void show(double[] z) {
        if (z[0] >= 0) StdOut.print("+");
        else           StdOut.print("-");
        StdOut.printf("%7.5f ", Math.abs(z[0]));

        if (z[1] >= 0) StdOut.print("+ ");
        else           StdOut.print("- ");
        StdOut.printf("%7.5fi ", Math.abs(z[1]));
    }
    public static double[] N(double[] z) {
        double[] one = {1.0, 0.0};
        double[] num = sca(mul(mul(z, z), z), 2);   // 2z^3
        double[] den = sub(sca(mul(z, z), 3), one); // 3z^2 - 1
        return div(num, den);                       // N(z) = num/den
    }
    public static double[] f(double[] z) {
        double[] one = {1.0, 0.0};
        return add(mul(z, z), one);
    }
    public static void eval(double[] z) {
        double e = 1E-15;
        for (int i = 0; mag(f(z)) > e; i++) {
            StdOut.printf("%3d  ", i);
            show(z);
            StdOut.printf("%7.5f\n", mag(f(z)));
            z = N(z);
        }
    }
    public static void main(String[] args) {
        double re = Double.parseDouble(args[0]);
        double im = Double.parseDouble(args[1]);
        double[] z0 = {re, im};
        eval(z0);
    }
}

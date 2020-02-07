public class Lagrange {
    public static double L(double[] x, double v, int k) {
        double num = 1;
        double den = 1;
        for (int i = 0; i < x.length; i++) {
            if (i != k) {
                num = num * (v -  x[i]);
                den = den * (x[k]-x[i]);
            }
        }
        return num/den;
    }
    public static double p(double[] x, double[] y, double v) {
        double sum = 0;
        for (int i = 0; i < x.length; i++)
            sum = sum + y[i]*L(x, v, i);
        return sum;
    }
    public static double f(double x) {
        return Math.cos(x);
    }
    public static void main(String[] args) {
        int N     = 8;
        double h  = 0.2;
        double x0 = 0.8;
        double[] x = new double[N+1];
        double[] y = new double[N+1];
        x[0] = x0;
        y[0] = f(x0);


        StdDraw.setXscale(-x0-h*N-1,  x0+h*N + 1);
        StdDraw.setYscale(-2, 2);
        StdDraw.line(-x0-h*N, 0, x0+h*N, 0);
        StdDraw.line(0, 1, 0, -1);

        for (int i = 1; i <= N; i++) {
            x[i] = x[i-1] + h;
            y[i] = f(x[i]);
            StdDraw.line(x[i-1], y[i-1], x[i], y[i]);
        }

        double[] yhat = new double[N+1];
        for (int i = 1; i <= N; i++)
            StdDraw.line(x[i-1], p(x, y, x[i-1]), x[i], p(x, y, x[i]));

        double v = 0.9;
        double est = p(x, y, v);
        double rev = f(v);
        StdOut.printf("est: %.15f rev: %.15f err: %.15f\n", est, rev, est-rev);
    }
}

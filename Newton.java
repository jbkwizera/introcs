
public class Newton {
	// Newton-Raphson sqrt approximation
	public static double sqrt(double x) {
		if (x < 0) return Double.NaN;
		double e = 1E-15;
		double t = x;
		while (Math.abs(t - x/t) > e*t)
			t = (t + x/t) / 2.0;

		return t;
	}
	// Newton approx. for any root
	public static double root(double x, double N) {
		double e = 1E-15;
		double t = x;
		double p = 0;

		while(Math.abs(p - t) > e*t) {
			double f  = Math.pow(t, N) - x;
			double fp = N * Math.pow(t, N-1);
			p = t;
			t = t - f / fp;
		}
		return t;
	}
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double N = Double.parseDouble(args[1]);

		double r = root(x, N);
		double v = Math.pow(x, 1/N);
		StdOut.printf("Eval: %.15f\n", r);
		StdOut.printf("Real: %.15f\n", v);
	}
}

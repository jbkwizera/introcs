public class Gaussian {
	public static double phi(double x) {
		return Math.exp(-x*x/2) / Math.sqrt(2*Math.PI);
	}
	public static double Phi(double z) {
		if (z < -8.0) return 0.0;
		if (z > +8.0) return 1.0;
		double sum = 0, term = z;
		for (int i = 3; sum != sum + term; i += 2) {
			sum  = sum + term;
			term = term * z * z / i;
		}
		return 0.5 + phi(z) * sum;
	}
	public static double PhiInverse(double y) {
		double lo = -8.0;
		double hi = +8.0;
		double dt = 1E-15;
		return PhiInverse(y, dt, lo, hi);
	}
	public static double PhiInverse(double y, double dt,
		        					double lo, double hi) {
		double mid = lo + (hi - lo)/2;
		if (hi - lo < dt)  return mid;
		if (Phi(mid) > y)
			 return PhiInverse(y, dt, lo, mid);
		else return PhiInverse(y, dt, mid, hi);
	}
	public static void main(String[] args) {
		double z     = Double.parseDouble(args[0]);
		double mu    = Double.parseDouble(args[1]);
		double sigma = Double.parseDouble(args[2]);
		double p = Double.parseDouble(args[3])/100;

		StdOut.printf("%.3f\n", Phi((z - mu) /sigma));
		StdOut.printf("%.4f\n", phi(PhiInverse(p)));
		StdOut.printf("%.4f\n", PhiInverse(p));
	}
}

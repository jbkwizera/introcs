
public class Mathese {
	// round off v to k decimal places
	public static double round(double v, int k) {
		if (k == 0) return Math.round(v);
		double p = Math.pow(10, k);
		v = Math.round(v * p);
		return v / p;
	}
	public static double ln(double v) {
		return Math.log(v) / Math.log(Math.E);
	}
	public static double lg(double v) {
		return Math.log(v) / Math.log(2);
	}
	// binary as balance weights
	public static void binary(int N) {
		int v = 1;
		while (v <= N/2) v = 2*v;

		while (v > 0) {
			if (N < v)	{ StdOut.print(0);			}
			else		{ StdOut.print(1); N -= v; 	}
			v = v/2;
		}
		StdOut.println();
	}
	// from decimal to any base k > 1
	public static String base(int N, int k) {
		if (N <= k) return N + "";

		String s = "";
		for (int n = N; n > 0; n /= k) {
			int v = n % k;
			if (v < 10) s = v + s;
			else s = (char)(v - 10 + 'A') + s;
		}
		return s;
	}
	public static String base(long N, int k) {
		if (N <= k) return N + "";

		String s = "";
		for (long n = N; n > 0; n /= k) {
			long v = n % k;
			if (v < 10) s = v + s;
			else s = (char)(v - 10 + 'A') + s;
		}
		return s;
	}
	public static void main(String[] args) {
		double v = Double.parseDouble(args[0]);
		int k = Integer.parseInt(args[1]);
		int N = Integer.parseInt(args[2]);
		int b = Integer.parseInt(args[3]);

		StdOut.println(v + " ≈ " + round(v, k));
		StdOut.print(N + " bin = ");
		binary(N);
		StdOut.println(N + " base " + b + " = " + base(N, b));
	}
}

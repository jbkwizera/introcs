import java.math.BigInteger;
public class Euclid {
	public static double distance(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		if (m != n) throw new RuntimeException("Illegal Dimensions");

		double sum = 0.0;
		for (int i = 0; i < m; i++) {
			int x = a[i], y = b[i];
			sum += (x - y)*(x - y);
		}
		return Math.sqrt(sum);
	}
	public static int gcd(int p, int q) {
		if (q == 0) return p;
		return gcd(q, p % q);
	}
	public static BigInteger gcd(BigInteger p, BigInteger q) {
		if (q.equals(BigInteger.ZERO)) return p;
		return gcd(q, p.mod(q));
	}
	public static int lcm(int p, int q) {
		return p * q/gcd(p, q);
	}
	public static int gcd(int...v) {
		int N = v.length;
		int d = v[0];
		for (int i = 1; i < N; i++)
			d = gcd(d, v[i]);

		return d;
	}
	public static int lcm(int...v) {
		int N = v.length;
		int m = v[0];
		for (int i = 1; i < N; i++)
			m = lcm(m, v[i]);

		return m;
	}
	public static boolean coprime(int p, int q)
	{	return gcd(p, q) == 1;	}
	public static boolean coprime(int...v)
	{	return gcd(v) == 1;		}

	public static void main(String[] args) {
		int p = Integer.parseInt(args[0]);
		int q = Integer.parseInt(args[1]);
		int d = lcm(p, q);
		StdOut.println(d);
	}
}

public class Horner {

	// Evaluation a polynomial with coef p[] at x0 = v.
	public static double eval(double[] p, double v) {
		double res = p[0];
		for (int i = 1; i < p.length; i++)
			res = res*v + p[i];
		return res;
	}
	
	// Implementation of math.exp(x).
	public static double exp(double x, int N) {
		double[] v = new double[N+1];
		v[0] = 1.0;
		for (int i = 1; i <= N; i++)
			v[i] = v[i-1] * x/i;
		
		for (int i = 0; i <= N/2; i++) {
			double temp = v[N-i-1];
			v[N-i-1] = v[i];
			v[i] = temp;
		}
		double sum = eval(v, 1);
		return sum;
	}
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		int N = Integer.parseInt(args[1]);
		double s1 = exp(x, N);
		double s2 = Taylor.exp(x);
		double s3 = Math.exp(x);
		StdOut.printf("Horner s %.15f\n", s1);
		StdOut.printf("Taylor s %.15f\n", s2);
		StdOut.printf("Math   s %.15f\n", s3);
	}
}
	
	

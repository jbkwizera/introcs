public class Binomial {
	public static int[][] coefficients(int N) {
		int[][] a = new int[N+1][];
		for (int n = 0; n <= N; n++) {
			a[n] = new int[n+1];
			a[n][0] = a[n][n] = 1;
			for (int k = 1; k < n; k++)
				a[n][k] = a[n-1][k] + a[n-1][k-1];
		}
		return a;
	}
	public static int coef(int N, int k) {
		int[][] a = coefficients(N);
		return a[N][k];
	}
		// also recusive...
	public static int recurseCoef(int N, int k) {
		if (N == 0 || k < 0) return 1;
		return recurseCoef(N-1, k) + recurseCoef(N-1, k-1);
	}
	public static double[][] distribution(int N) {
		double[][] a = new double[N+1][];
		int[][] coef = coefficients(N);

		for (int n = 0; n <= N; n++) {
			a[n] = new double[n+1];
			double dv = Math.pow(2, n);
			for (int k = 0; k <= n; k++)
				a[n][k] = coef[n][k]/dv;
		}
		return a;
	}
	public static double prob(int N, int k) {
		double[][] a = distribution(N);
		return a[N][k];
	}
	// also recursive...
	public static double recurseProb(int N, int k) {
		if (N == 0 || k < 0) return 1.0;
		return (recurseProb(N-1, k) + recurseProb(N-1, k-1))/2.0;
	}
	public static void showCoefficients(int N) {
		int[][] a = coefficients(N);
		int mx    = 0;
		for (int k = 0; k <= N; k++)
			if (a[N][k] > mx) mx = a[N][k];

		int w = (""+ mx).length();
		String f = "%" + w + "d ";
		for (int n = 0; n <= N; n++)
			for (int k = 0; k <= n; k++)
				StdOut.printf(f, a[n][k]);
			StdOut.println();
	}
	public static void showDistribution(int N) {
		double[][] a = distribution(N);
		for (int n = 0; n <= N; n++)
			for (int k = 0; k <= n; k++)
				StdOut.printf("%6.4f ", a[n][k]);
			StdOut.println();
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);

		int[][] a = coefficients(N);
		StdOut.print("     |");
		for (int i = 0; i < N; i++)
			StdOut.printf("%5d ", i);
		StdOut.println();

		StdOut.print("-----");
		for (int i = 0; i < N; i++)
			StdOut.print("------");
		StdOut.println();

		for (int i = 0; i < N; i++) {
			StdOut.printf("%5d|", i);
			for (int j = 0; j < a[i].length; j++)
				StdOut.printf("%5d ", a[i][j]);
			StdOut.println();
		}
	}
}

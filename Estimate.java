public class Estimate {
	public static double eval(int N, double p, int T) {
		int cnts = 0;
		for (int t = 0; t < T; t++) {
			boolean[][] open = Percolation.random(N, p);
			boolean[][] full = Percolation.flow(open);
			if (Percolation.percolates(full)) cnts++;
		}
		return cnts*1.0/T;
	}
	public static void main(String[] args) {
		int    N = Integer.parseInt(args[0]);
		double p = Double.parseDouble(args[1]);
		int T    = Integer.parseInt(args[2]);
		StdOut.printf("estimate p: %6.4f\n", eval(N, p, T));
	}
}
			

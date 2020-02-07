public class PercolationEZ {
	public static boolean[][] flow(boolean[][] open) {
		int N = open.length;
		boolean[][] full = new boolean[N][N];
		// percolation flow computation
		for (int j = 0; j < N; j++)
			full[0][j] = open[0][j];
		for (int i = 1; i < N; i++)
			for (int j = 0; j < N; j++)
				full[i][j] = open[i][j] && full[i-1][j];
		return full;
	}
	public static boolean percolates(boolean[][] open) {
		boolean[][] full = flow(open);
		int N = full.length;
		for (int j = 0; j < N; j++)
			if (full[N-1][j]) return true;
		return false;
	}
	public static void show(boolean[][] a, boolean which) {
		int N = a.length;
		StdDraw.setXscale(-1, N);
		StdDraw.setYscale(-1, N);
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (a[i][j] == which)
					StdDraw.filledSquare(j, N-i-1, 0.5);
	}
	public static boolean[][] random(int N, double p) {
		boolean[][] a = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				a[i][j] = StdRandom.bernoulli(p);
		return a;
	}
	public static void main(String[] args) {
		boolean[][] open = StdArrayIO.readBoolean2D();
		StdArrayIO.print(flow(open));
		StdOut.println(percolates(open));
	}
}

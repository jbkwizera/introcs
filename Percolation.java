public class Percolation {
	public static boolean[][] flow(boolean[][] open) {
		int N = open.length;
		boolean[][] full = new boolean[N][N];
		// percolation flow computation
		for (int j = 0; j < N; j++)
			flow(open, full, 0, j);
		return full;
	}
	public static void flow(boolean[][] open,
						    boolean[][] full, int i, int j) {
		int N = full.length;
		if (i < 0 || i >= N) return;
		if (j < 0 || j >= N) return;
		if (!open[i][j]) return;
		if ( full[i][j]) return;
		full[i][j] = true;
		flow(open, full, i+1, j);
		flow(open, full, i, j+1);
		flow(open, full, i, j-1);
		flow(open, full, i-1, j);
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
	public static void print(boolean[][] open) {
		boolean[][] full = flow(open);
		int N = full.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if 		(full[i][j]) StdOut.print("* ");
				else if (open[i][j]) StdOut.print("1 ");
				else				 StdOut.print("0 ");
			}
			StdOut.println();
		}
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

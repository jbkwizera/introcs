public class Visualize {
	public static void main(String[] args) {
		int    N = Integer.parseInt(args[0]);
		double p = Double.parseDouble(args[1]);
		int T    = Integer.parseInt(args[2]);


		for (int t = 0; t < T; t++) {
			boolean[][] open = Percolation.random(N, p);
			StdDraw.clear();
			StdDraw.setPenColor(StdDraw.BLACK);
			Percolation.show(open, false);
			StdDraw.setPenColor(StdDraw.BLUE);
			boolean[][] full = Percolation.flow(open);
			Percolation.show(full, true);
			StdDraw.show(2000);
		}
	}
}

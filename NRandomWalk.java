
public class NRandomWalk {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);

		boolean[][] v = new boolean[N][N];
		int[] x = new int[N];
		int[] y = new int[N];
		for (int i = 0; i < N; i++) {
			x[i] = N/2;
			y[i] = N/2;
		}
		int cells = N*N;
		int steps = 0;
		v[N/2][N/2] = true;
		cells--;

		while (cells > 0) {
			steps++;
			for (int i = 0; i < N; i++) {
				double r = Math.random();
				if 		(r < 0.25) x[i]++;
				else if 	(r < 0.50) x[i]--;
				else if 	(r < 0.75) y[i]++;
				else if 	(r < 1.00) y[i]--;

				if (x[i] < N && y[i] < N &&
					x[i] >= 0 && y[i] >= 0 && !v[x[i]][y[i]]) {
					cells--;
					v[x[i]][y[i]] = true;
				}
			}
		}
		StdOut.println(steps);
	}
}

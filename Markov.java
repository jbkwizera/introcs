
public class Markov {
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		int N = StdIn.readInt();
		StdIn.readInt();

		double[][] p = new double[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				p[i][j] = StdIn.readDouble();

		double[] rank = new double[N];
		rank[0] = 1.0;
		for (int t = 0; t < T; t++) {
			double[] newRank = new double[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					newRank[i] += rank[j]*p[j][i];
			}
			for (int i = 0; i < N; i++)
				rank[i] = newRank[i];
		}
		for (int i = 0; i < N; i++)
			StdOut.printf("%8.5f", rank[i]);
		StdOut.println();
	}
}

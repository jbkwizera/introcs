
public class Transition {
	public static void main(String[] args) {
		int N = StdIn.readInt();
		int[][] counts = new int[N][N];
		int[] outDegree = new int[N];
		
		while (!StdIn.isEmpty()) {
			int i = StdIn.readInt();
			int j = StdIn.readInt();
			counts[i][j]++;
			outDegree[i]++;
		}
		
		StdOut.println(N + " " + N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				double p = counts[i][j]*0.90/outDegree[i] + 0.10/N;
				StdOut.printf("%8.5f", p);
			}
			StdOut.println();
		}			   
	}
}

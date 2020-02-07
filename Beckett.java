public class Beckett {
	public static void moves(int N, boolean enter, int[] v) {
		if (N == 0) return;
		moves(N-1, true, v);
		if (enter) {
			StdOut.printf("enter %d: ", N);
			v[N-1] = 1;
			for (int x: v) StdOut.print(x);
			StdOut.println();
		}
		else {
			StdOut.printf("exit  %d: ", N);
			v[N-1] = 0;
			for (int x: v) StdOut.print(x);
			StdOut.println();
		}
		moves(N-1, false, v);
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int[] v = new int[N];
		moves(N, true, v);
	}
}

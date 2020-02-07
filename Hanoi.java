public class Hanoi {
	public static void moves(int N, boolean right) {
		if (N == 0) return;
		moves(N-1, !right);
		if (right)	StdOut.println(N + " right");
		else		StdOut.println(N + " left");
		moves(N-1, !right);
	}
	// even: move right, odd: move left
	public static String moves(int N) {
		if (N == 0) return "";
		return moves(N-1) + N + moves(N-1);
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		moves(N, true);
	}
}

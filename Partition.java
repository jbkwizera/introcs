public class Partition {
	public static int eval(int N) {
		return eval(N, N);
	}
	public static int eval(int n, int m) {
		if (m == 0 || n <  0) return 0;
		if (n == 0 || m == 1) return 1;
		if (n == m) return 1 + eval(n, m-1);
		return  eval(n, m-1) + eval(n-m, m);
	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		StdOut.println("p(" + N + ") = " + eval(N));
	}
}

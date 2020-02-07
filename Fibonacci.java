public class Fibonacci {
	// n-nacci!
	public static int eval(int n, int m)
	{	return eval1(n+1, m);	}

	private static int eval1(int n, int m) {
		if  (n <= 1) return n;
		int res = 0;
		for (int k = 1; k <= m && k <= n; k++)
			res = res + eval1(n-k, m);
		return res;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[0]);
		StdOut.println(eval(n, m));
	}
}

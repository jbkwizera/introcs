public class Factorize {
	public static void main(String[] args) {
		long N = Long.parseLong(args[0]);
		eval(N);
	}
	public static int pcount(int N) {
		int count = 0;
		int prev  = 1;
		for (int v = 2; v <= N/v; v++) {
			if (N % v == 0) {
				while (N % v == 0)
					N /= v;
				count++;
				prev =v;
			}
		}
		if (N > 1 && N != prev) count++;
		return count;
	}
	public static int fcount(int N) {
		int count = 1;
		int prev  = 1;
		int curc  = 0;
		for (int v = 2; v <= N/v; v++) {
			curc  = 0;
			if (N % v == 0) {
			 	while (N % v == 0) {
					N /= v;
					curc++;
				}
				count *= (curc + 1);
				prev   = v;
			}
		}
		if (N > 1) {
			if (N == prev)
				 count = (count/curc) * (curc+1);
			else count = count * 2;
		}
		return count;
	}
	public static void eval(long N) {
		StdOut.println(N);
		for (long v = 2; v <= N/v; v++) {
			while (N % v == 0) {
				StdOut.print(v + " ");
				N /= v;
			}
		}
		if (N > 1)	StdOut.print(N);
		StdOut.println();
	}
}

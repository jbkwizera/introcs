
public class Factorial {
	// factorizing kind of brute force
	public static int factors0(int N) {
		int[] counts = new int[N+2];
		for (int n = 2; n <= N; n++) {
			int v = n;
			for (int i = 2; i <= v/i; i++) {
				while (v % i == 0) {
					counts[i]++;
					v /= i;
				}
			}
			if (v > 1) counts[v]++;
		}
		int sum = 0;
		for (int i = 2; i <= N; i++)
			sum += counts[i];
		return sum;
	}
	// eratosthenes + knuth
	public static int factors(int N) {
		boolean[] isPrime = Prime.sieve(N);
		int sum = 0;
		for (int i = 2; i <= N; i++)
			if (isPrime[i])
				for (int v = N/i; v > 0; v /= i)
					sum += v;
		return sum;
	}
	public static int eval(int N) {
		if (N <  0) return -1;
		if (N <= 1) return +1;
		return N * eval(N -1);
	}
	public static int numZeros(int N) {
		int cnt = 0;
		for (int v = 5; v <= N; v *= 5) // 89/5 + 85/25 = 17 + 3
			cnt += N/v;
		return cnt;
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int count = factors(N);
		StdOut.println(count);
	}
}

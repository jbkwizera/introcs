public class Prime {
	public static boolean[] sieve(int N) {
		boolean[] isPrime = new boolean[N+2];
		for (int i = 2; i <= N; i++)
			isPrime[i] = true;

		for (int i = 2; i <= N/i; i++)
			if (isPrime[i])
				for (int j = i; j <= N/i; j++)
					isPrime[i * j] = false;
		return isPrime;
	}
	public static int pi(int N) {
		boolean[] a = sieve(N);
		int count = 0;
		for (int i = 2; i <= N; i++)
			if (a[i]) count++;
		return count;
	}
	public static boolean is(int N) {
		if (N < 2)	return false;
		for (int i = 2; i <= N/i; i++)
			if (N % i == 0)
				return false;
		return true;
	}
	public static int[] seq(int N) {
		int[] a  = new int[N];
		int temp = 2;
		for (int i = 0; i < N; i++) {
			while (!is(temp)) temp++;
			a[i] = temp;
			temp++;
		}
		return a;
	}
	public static boolean coprime(int N, int M) {
		return Euclid.gcd(N, M) == 1;
	}
	public static int phi(int N) {
		int cnt = 0;
		for (int i = 1; i <= N; i++)
			if (coprime(i, N))
				cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		//int N = Integer.parseInt(args[0]);
		//kdkfdkf `
		int N = 100000000;
		int count = 0;
		boolean[] isPrime = sieve(N);
		for (int i = 0; i < isPrime.length; i++)
			if (isPrime[i]) StdOut.println(i);
	}
}

// check knuth: concrete math p.8-10
public class Josephus {
	public static void main(String[] args) {
		long N = Long.parseLong(args[0]);

		System.out.println("closed: "+closed(N));
		System.out.println("recursive: "+recurs(N));
	}
	public static long closed(long N) {
		long v = 1;
		while (v <= N/2) v *= 2;

		long m = 2*(N-v) + 1;
		return m;
	}
	public static long recurs(long N) {
		if (N == 1) return 1;
		if (N % 2 == 0) return 2*recurs(N/2) - 1;
		return 2*recurs(N/2) + 1;
	}
}

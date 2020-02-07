
public class Coupon {
	public static int uniform(int N) {
		return (int)(Math.random() * N);
	}
	public static int collect(int N) {
		boolean[] found = new boolean[N];
		int cardcnt = 0, vcnt = 0;
		while (vcnt < N) {
			int v = uniform(N);
			cardcnt++;
			if (!found[v]) vcnt++;
			found[v] = true;
		}
		return cardcnt;
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		StdOut.println(collect(N));
	}
}

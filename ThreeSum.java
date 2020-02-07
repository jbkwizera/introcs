public class ThreeSum {
	public static void printAll(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++)
			for (int j = i+1; j < N; j++)
				for (int k = j+1; k < N; k++)
					if (a[i] + a[j] + a[k] == 0)
						StdOut.printf("%8d %8d %8d\n", a[i], a[j], a[k]);
	}
	public static void closest(int[] a, int x) {
		int mn = Integer.MAX_VALUE;
		int N  = a.length;
		for (int i = 0; i < N; i++)
			for (int j = i+1; j < N; j++)
				for (int k = j+1; k < N; k++)
					if (Math.abs(a[i] + a[j] + a[k] - x) < mn)
						mn = Math.abs(a[i] + a[j] + a[k] - x);
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					if (Math.abs(a[i] + a[j] + a[k] - x) == mn) {
						StdOut.printf("%8d %8d %8d\n", a[i], a[j], a[k]);
						cnt++;
					}
				}
			}
		}
		StdOut.println(cnt + " triples in " + mn + " radius from " + x);
	}
	public static int count(int[] a) {
		int cnt = 0;
		int N = a.length;
		for (int i = 0; i < N; i++)
			for (int j = i+1; j < N; j++)
				for (int k = j+1; k < N; k++)
					if (a[i] + a[j] + a[k] == 0)
						cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		int x   = Integer.parseInt(args[0]);
		int[] a = StdIn.readAllInts();
		int cnt = count(a);
		StdOut.println(cnt + " triples w/ sum = 0");
		printAll(a);
		StdOut.println("\ntriples w/ sum closest to " + x + ": ");
		closest(a, x);
	}
}

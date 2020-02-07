public class Insertion {
	public static <Key extends Comparable<Key>> void sort(Key[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++)
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
				exch(a, j, j-1);
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	private static boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		for (String x: a) StdOut.print(x + " ");
		StdOut.println();

		sort(a);
		for (String x: a) StdOut.print(x + " ");
			StdOut.println();
	}
}

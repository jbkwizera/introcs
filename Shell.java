public class Shell {
    public static <Key extends Comparable<Key>> void sort(Key[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;
        while (h >= 1) {
            // h-sort the array...
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h = h/3;
        }
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
		//for (String x: a) StdOut.print(x + " ");
		//StdOut.println();

		sort(a);
		//for (String x: a) StdOut.print(x + " ");
		//StdOut.println();
    }
}

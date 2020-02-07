public class Selection {
    public static <Key extends Comparable<Key>> void sort(Key[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++)
                if (a[min].compareTo(a[j]) > 0)
                    min = j;
            exch(a, min, i);
        }
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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


public class Kadane {
	// Maximum subarray problem.
	public static String maxSub(int[] a) {
		int start = 0;
		int end   = 0;
		int index = 0;
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;

		for (int i = 0; i < a.length; i++) {
			maxEndingHere = maxEndingHere + a[i];
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				start = index;
				end = i + 1;
			}
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
				index = i + 1;
			}
		}
		return String.format("%d: [%d, %d)",
			   maxSoFar, start, end);
	}
	// Find i, j, j > i: Aj - Ai is maximum.
	public static String beatStocks(int[] a) {
		int min = 0;
		int dif = 0;
		int buy = 0;
		int sel = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < a[min]) min = i;
			if (a[i] - a[min] > dif) {
				dif = a[i] - a[min];
				buy = min;
				sel = i;
			}
		}
		return String.format("$%d. Buy @%d. Sell @%d",
			   dif, buy, sel);
	}
	public static void main(String[] args) {
		int[] a = StdIn.readAllInts();
		StdOut.println(beatStocks(a));
		StdOut.println(maxSub(a));
	}
}

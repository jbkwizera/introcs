public class BinarySearch {
	// any instance of key
	public static int search(String[] a, String key) {
		//return search(key, a, 0, a.length);
		// @non-recursive solution
		int lo = 0;
		int hi = a.length - 1;
		while (lo  <= hi) {
			int mid = lo + (hi - lo) /2;
		    int cmp = a[mid].compareTo(key);
			if 			(cmp > 0) hi = mid - 1;
			else if (cmp < 0) lo = mid + 1;
			else 	return mid;
		}
		return -1;
	}
	private static int search(String[] a, String key, int lo, int hi) {
		if (hi <= lo) return -1;
		int mid = lo + (hi - lo) /2;
		int cmp = a[mid].compareTo(key);
		if 		(cmp > 0) return search(a, key, lo, mid);
		else if (cmp < 0) return search(a, key, mid+1, hi);
		else    return mid;
	}
	// first instance of key
	public static int indexOf(String[] a, String key) {
		return indexOf(a, key, 0, a.length);
	}
	private static int indexOf(String[] a, String key, int lo, int hi) {
		if (hi <= lo) return -lo;
		int mid = lo + (hi - lo) /2;
		int cmp = a[mid].compareTo(key);
		if 		(cmp > 0) return indexOf(a, key, lo, mid);
		else if (cmp < 0) return indexOf(a, key, mid+1, hi);
				// if mid was the first return it or keep searching
		if		(mid == 0 || !a[mid].equals(a[mid-1])) return mid;
		return  indexOf(a, key, lo, mid);
	}

	// last instance of key
	public static int lastIndexOf(String[] a, String key) {
		return lastIndexOf(a, key, 0, a.length);
	}
	private static int lastIndexOf(String[] a, String key, int lo, int hi) {
		if (hi <= lo) return -hi;
		int mid = lo + (hi - lo) /2;
		int cmp = a[mid].compareTo(key);
		if		(cmp > 0) return lastIndexOf(a, key, lo, mid);
		else if (cmp < 0) return lastIndexOf(a, key, mid+1, hi);
		// if mid was the last return it or keep searching
		if      (mid == a.length-1 || !a[mid].equals(a[mid+1])) return mid;
		return lastIndexOf(a, key, mid+1, hi);
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		String[] a = in.readAll().split("[^a-zA-Z0-9]+");
		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();
			if (search(a, key) < 0) StdOut.println(key);
	    }
	}
}

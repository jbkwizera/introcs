import java.util.NoSuchElementException;
import java.util.Arrays;
public class BinarySearchST {
	private String[] keys;
	private int[] vals;
	private int N;

	public BinarySearchST() {
		keys = new String[1];
		vals = new int[1];
		N    = 0;
	}
	public int size() { return N; }
	public boolean isEmpty() { return N == 0; }

	public boolean contains(String key) {
		return search(key) >= 0;
	}
	public int get(String key) {
		int k = search(key);
		if (k >= 0) return vals[k];
		throw new NoSuchElementException();
	}
	public void put(String key, int val) {
		int k = search(key);
		if (k >= 0) {
			vals[k] = val;
			return;
		}
		if (N == keys.length) resize(2*N);
		int i = N;
		while (i > 0 && key.compareTo(keys[i-1]) < 0) {
			keys[i] = keys[i-1];
			vals[i] = vals[i-1];
			i--;
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < N; i++)
			s += String.format("%6s: %2d\n", keys[i], vals[i]);
		return s;
	}
	/*-----------------------helper private methods-------------------*/
	private int search(String key) {
		return search(key, 0, N);
	}
	private int search(String key, int lo, int hi) {
		if (hi <= lo) return -1;
		int mid = lo + (hi - lo)/2;

		int cmp = keys[mid].compareTo(key);
		if 		(cmp > 0) return search(key, lo, mid);
		else if (cmp < 0) return search(key, mid+1, hi);
		else	return mid;
	}
	private void resize(int max) {
		String[] temk = new String[max];
		int[] temv    = new int[max];
		for (int i = 0; i < N; i++) {
			temk[i] = keys[i];
			temv[i] = vals[i];
		}
		keys = temk;
		vals = temv;
	}
	/*************************client***********************************/
	public static void main(String[] args) {
		BinarySearchST bt;
		bt = new BinarySearchST();

		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (!bt.contains(s)) bt.put(s, 0);
			bt.put(s, bt.get(s) + 1);
		}
		StdOut.println(bt);
	}
}

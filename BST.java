import java.util.NoSuchElementException;
import java.util.Iterator;
public class BST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
	private Node root;
	private class Node {
		Key key;
		Value val;
		Node left, right;
		int N;
		Node (Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N   = N;
		}
	}
	public int size() {
		return size(root);
	}
	private int size(Node x) {
		if (x == null) return 0;
		return x.N;
	}
	public boolean isEmpty() {
		return root == null;
	}
	public Value get(Key key) {
		return get(root, key);
	}
	private Value get(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if 		(cmp < 0) return get(x.left,  key);
		else if (cmp > 0) return get(x.right, key);
		else			  return x.val;
	}
	public boolean contains(Key key) {
		return get(key) != null;
	}
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	private Node put(Node x, Key key, Value val) {
		if (x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if		(cmp < 0) x.left  = put(x.left,  key, val);
		else if (cmp > 0) x.right = put(x.right, key, val);
		else              x.val   = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	private class BSTIterator implements Iterator<Key> {
		Stack<Node> stack = new Stack<Node>();
		private BSTIterator() {
			pushLeft(root);
		}
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		public Key next() {
			Node x = stack.pop();
			pushLeft(x.right);
			return x.key;
		}
		public void remove() { }
		private void pushLeft(Node x) {
			while (x != null) {
				stack.push(x);
				x = x.left;
			}
		}
	}
	public Iterator<Key> iterator() {
		return new BSTIterator();
	}
	public String toString() {
		String s = "";
		for (Key key: this)
			s += key + ": "+ get(key) + "\n";
		s = s.trim();
		return s;
	}
	/************extended operations***********/
	public Key min() {
		if (isEmpty()) throw new NoSuchElementException("BST is empty.");
		return min(root);
	}
	private Key min(Node x) {
		if (x.left == null) return x.key;
		return min(x.left);
	}
	public Key max() {
		if (isEmpty()) throw new NoSuchElementException("BST is empty.");
		return max(root);
	}
	public Key max(Node x) {
		if (x.right == null) return x.key;
		return max(x.right);
	}
	public void remove(Key key) { } 	// complete
	public void range(Key a, Key b) { } // complete

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		BST<String, Integer> st;
		st = new BST<String, Integer>();
		for (int i = 0; i < a.length; i++) {
			String s = a[i];
			if (!st.contains(s)) st.put(s, 0);
			int v = st.get(s);
			st.put(s, v+1);
			StdOut.println(s + " -- " + st.size());
		}
		StdOut.println(st);
	}
}

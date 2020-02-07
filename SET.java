import java.util.Iterator;
public class SET<Key extends Comparable<Key>> implements Iterable<Key> {
	private Node root;
	private class Node {
		int N;
		Key key;
		Node left, right;
		Node (Key key, int N) {
			this.key = key;
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
	public void add(Key key) {
		root = add(root, key);
	}
	private Node add(Node x, Key key) {
		if (x == null)	return new Node(key, 1);
		int cmp = key.compareTo(x.key);
		if 		(cmp < 0) x.left  = add(x.left,  key);
		else if	(cmp > 0) x.right = add(x.right, key);
		else			  x.key   = key;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	public boolean contains(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if 		(cmp < 0) x = x.left;
			else if (cmp > 0) x = x.right;
			else	return true;
		}
		return false;
	}
	private class SETIterator implements Iterator<Key> {
		Stack<Node> stack = new Stack<Node>();
		private SETIterator() {
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
		return new SETIterator();
	}
	public String toString() {
		String s = "";
		for (Key key: this) s += key + " ";
		return s.trim();
	}
	public static void main(String[] args) {
		SET<String> distinct = new SET<String>();
		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();
			if (!distinct.contains(key)) {
				distinct.add(key);
				StdOut.println(key);
			}
		}
	}
}

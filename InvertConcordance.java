public class InvertConcordance {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);

		BST<Integer, Queue<String>> st;
		st = new BST<Integer, Queue<String>>();

		while (!StdIn.isEmpty()) {
			String[] a = StdIn.readLine().split(": ");
			String s   = a[0];
			String[] l = a[1].split(" ");
			for (int i = 0; i < l.length; i++) {
				int v = Integer.parseInt(l[i]);
				if (!st.contains(v))
					st.put(v, new Queue<String>());
				Queue<String> q = st.get(v);
				q.enqueue(a[0]);
			}
		}
		int count = 0;
		for (int v: st) {
			Queue<String> q = st.get(v);
			StdOut.print(q);
			count += q.size();
			if (count >= N)
				break;
		}
		StdOut.println();
	}
}

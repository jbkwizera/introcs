public class IndexGraph {
	public static void main(String[] args) {
		// Build a graph and process queries.
		In in = new In(args[0]);
		String delim = args[1];
		Graph G = new Graph(in, delim);
		while (!StdIn.isEmpty()) {
			String v = StdIn.readLine();
			for (String w: G.adjacentTo(v))
				StdOut.println("  " + w);
		}
	}
}

public class PathFinder {
	private ST<String, String>  prev;
	private ST<String, Integer> dist;

	public PathFinder(Graph G, String s) {
		// Use BFS to compute distances and previous node
		// on shortest path from s to each vertex.
		prev = new ST<String, String>();
		dist = new ST<String, Integer>();
		Queue<String> q = new Queue<String>();
		q.enqueue(s);
		dist.put(s, 0);
		while (!q.isEmpty()) {
			// Process next vertex on queue.
			String v = q.dequeue();
			for (String w: G.adjacentTo(v)) {
				// Check whether distance is already known.
				if (!dist.contains(w)) {
					// Add to queue and save shortest-path information.
					q.enqueue(w);
					dist.put(w, 1 + dist.get(v));
					prev.put(w, v);
				}
			}
		}
	}
	public int distanceTo(String v) {
		return dist.get(v);
	}
	public Iterable<String> pathTo(String v) {
		// Return iterable object having shortest path from s to v.
		Stack<String> path = new Stack<String>();
		while (v != null && dist.contains(v)) {
			// push current vertex; move to previous vertex on path.
			path.push(v);
			v = prev.get(v);
		}
		return path;
	}
	public static void main(String[] args) {
		// Read a graph and process queries
		// for shortest paths from s.
		In in = new In(args[0]);
		String delim = args[1];
		Graph G = new Graph(in, delim);
		String s = args[2];
		PathFinder pf = new PathFinder(G, s);
		while (!StdIn.isEmpty()) {
			// Print distance and shortest path from s to input t.
			String t = StdIn.readLine();
			int d    = pf.distanceTo(t);
			for (String v : pf.pathTo(t))
				StdOut.println("  " + v);
			StdOut.println("dist: " + d);
		}
	}
}

public class Graph {
	private ST<String, SET<String>> st;
	public Graph() {
		st = new ST<String, SET<String>>();
	}
	public Graph(In in, String delim) {
		st = new ST<String, SET<String>>();
		while (!in.isEmpty()) {
			String s = in.readLine();
			String[] names = s.split(delim);
			for (int i = 1; i < names.length; i++)
				addEdge(names[0], names[i]);
		}
	}
	public void addEdge(String v, String w) {
		// Put v in w's SET and w in v's SET.
		if (!st.contains(v)) st.put(v, new SET<String>());
		if (!st.contains(w)) st.put(w, new SET<String>());
		st.get(v).add(w);
		st.get(w).add(v);
	}
	public int degree(String v) {
		return st.get(v).size();
	}
	public int V() {
		return st.size();
	}
	public int E() {
		int cnt = 0;
		for (String v : st) cnt += degree(v);
		return cnt / 2;
	}
	public boolean hasVertex(String v) {
		return st.contains(v);
	}
	public boolean hasEdge(String v, String w) {
		if (st.contains(v) && st.get(v).contains(w))
			return true;
		if (st.contains(w) && st.get(w).contains(v))
			return true;
		return false;
	}
	public Iterable<String> adjacentTo(String v) {
		return st.get(v);
	}
	public Iterable<String> vertices() {
		return st;
	}
	public String toString() {
		String s = "";
		for (String v: vertices()) {
			s += v;
			for (String w: adjacentTo(v))
				s += " " + w;
			s += "\n";
		}
		return s;
	}
	public static void main(String[] args) {
		// Read edges, print Graph (sets of neighbors).
		Graph G = new Graph();
		while (!StdIn.isEmpty()) {
			String v = StdIn.readString();
			String w = StdIn.readString();
			G.addEdge(v, w);
		}
		StdOut.print(G);
	}
}

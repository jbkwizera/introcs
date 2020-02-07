public class Lookup {
	public static void main(String[] args) {
		// Build dictionary, provide values for keys in Stdln.
		In in = new In(args[0]);
		int keyField = Integer.parseInt(args[1]);
		int valField = Integer.parseInt(args[2]);

		String[] database = in.readAll().split("\n");
		// random BST -> guarrantees lgN
		StdRandom.shuffle(database);

		BST<String, Queue<String>> st;
		st = new BST<String, Queue<String>>();
		for (int i = 0; i < database.length; i++) {
			// Extract key, value from one line and add to ST.
			String[] tokens = database[i].split(",");
			String key = tokens[keyField];
			String val = tokens[valField];
			if (!st.contains(key))
				st.put(key, new Queue<String>());
			Queue<String> q = st.get(key);
			q.enqueue(val);
		}

		while (!StdIn.isEmpty()) {
			// Read key and provide values
			String s = StdIn.readString();
			if (st.contains(s))
				 StdOut.println(st.get(s));
			else StdOut.println("Not found");
		}
		//8,180,180,851
	}
}

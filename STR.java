public class STR {
	// Longest common prefix
	public static String lcp(String s, String t) {
		int N = Math.min(s.length(), t.length());
		for (int i = 0; i < N; i++)
			if (s.charAt(i) != t.charAt(i))
				return s.substring(0, i);
		return s.substring(0, N);
	}
	// Longest repeated substring
	public static String lrs(String s) {
		int N = s.length();
		String[] suffixes = new String[N];
		for (int i = 0; i < N; i++)
			suffixes[i] = s.substring(i, N);
		Merge.sort(suffixes);

		String res = "";
		for (int i = 1; i < N; i++) {
			String x = lcp(suffixes[i-1], suffixes[i]);
			if (x.length() > res.length()) res = x;
		}
		return res;
	}
	public static String lcs(String s, String t) {
		return "";
	}
	public static void main(String[] args) {
		String s = StdIn.readAll();
		StdOut.println(s.length());
		StdOut.println(lrs(s));
	}
}

public class Permutation {
	public static void eval(String s, String t) {
		if (s.length() == 0) {
			StdOut.println(t);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			String tTem = t + s.charAt(i);
			String sTem = s.substring(0, i) + s.substring(i+1);
			eval(sTem, tTem);
		}
	}
	public static void main(String[] args) {
		eval(args[0], "");
	}
}

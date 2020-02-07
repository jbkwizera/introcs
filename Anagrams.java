public class Anagrams {
	public static void eval(String s, String t) {
		if (s.length() == 0) {
			StdOut.println(t);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			String temT = t + s.charAt(i);
			String temS = s.substring(0, i) + s.substring(i+1);
			eval(temS, temT);
		}
	}
	public static void main(String[] args) {
		String s = args[0];
		eval(s, "");
	}
}

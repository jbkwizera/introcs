public class RecLCS {
    public static String find(String s, String t, int i, int j) {
        if (i == s.length() || j == t.length())
            return "";
        if (s.charAt(i) == t.charAt(j))
            return s.charAt(i) + find(s, t, i+1, j+1);
        String subs = find(s, t, i+1, j);
        String subt = find(s, t, i, j+1);
        if (subs.length() > subt.length())
            return subs;
        return subt;
    }
    public static void main(String[] args) {
        String s = args[0];
        String t = args[1];
        StdOut.println(find(s, t, 0, 0));
    }
}

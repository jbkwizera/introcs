public class LongestCommonSubsequence {
    public static String lcs(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] opt = new int[m+1][n+1];
        for (int i = m-1; i >= 0; i--)
            for (int j = n-1; j >= 0; j--)
                if (s.charAt(i) == t.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
        String lcs = "";
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                lcs += s.charAt(i);
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        return lcs;
    }
    private static String rec(char[] s, char[] t, int i, int j) {
        if (i == s.length || j == t.length)
            return "";
        if (s[i] == t[j])
            return s[i] + rec(s, t, i+1, j+1);
        String xs = rec(s, t, i+1, j);
        String xt = rec(s, t, i, j+1);
        if (xs.length() > xt.length())
            return xs;
        return xt;
    }
    public static String rec(String s, String t)
    {   return rec(s.toCharArray(), t.toCharArray(), 0, 0); }

    public static void main(String[] args) {
        String s = args[0];
        String t = args[1];
        StdOut.println(rec(s, t));
    }
}

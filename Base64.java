public class Base64 {
    private static char toChar(int i) {
        char ch = ' ';
        if      (i < 26) ch = (char)('A' + i);
        else if (i < 52) ch = (char)('a' + (i - 26));
        else if (i < 62) ch = (char)('0' + (i - 52));
        if (i == 62) ch = '+';
        if (i == 63) ch = '/';
        return ch;
    }
    public static String encode(String bin) {
        while (bin.length() % 6 != 0)
            bin = "0" + bin;
        int N = bin.length();
        String res = "";
        for (int i = 6; i <= N; i += 6) {
            String s = bin.substring(i-6, i);
            int val = Integer.parseInt(s, 2);
            res += toChar(val);
        }
        return res;
    }
    public static void main(String[] args) {
        StdOut.println(encode(args[0]));
    }
}

public class Converter {
    public static int toInt(char c) {
        if (c >= '0' && c <= '9') return c - '0';
        return c - 'A' + 10;
    }
    public static char toChar(int i) {
        if (i < 10) return (char)('0' + i);
        return (char)('A' + i - 10);
    }
    public static int parseInt(String s, int base) {
        int N = 0;
        for (int i = 0; i < s.length(); i++)
            N = base*N + toInt(s.charAt(i));
        return N;
    }
    public static String toString(int N, int base) {
        if (N == 0) return "";
        return toString(N /base, base) + toChar(N % base);
    }
    public static String toString(int N, int base, int size) {
        String s = toString(N, base);
        int len  = s.length();
        if (len > size) return s.substring(len-size);
        while (s.length() < size) s = "0" + s;
        return s;
    }
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            int baseFrom = StdIn.readInt();
            int baseTo = StdIn.readInt();

            int N = parseInt(s, baseFrom); // decimal.
            StdOut.println("decimal: " + N);
            StdOut.println(toString(N, baseTo));
        }
    }
}

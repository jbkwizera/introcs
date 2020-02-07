public class TwosComplement {
    public static String toString(long N, int base, int sz) {
        String s = "";
        if (N == 0) return "0";

        while (N > 0) {
            int rem = (int)(N % base);
            s = Converter.toChar(rem) + s;
            N = N / base;
        }
        while (s.length() < sz) s = '0' + s;
        return s;
    }
    public static void main(String[] args) {
        int N  = Integer.parseInt(args[0]); // number
        int sz = Integer.parseInt(args[1]); // bits


        long comp = N;
        if (comp < 0) comp = (1L << sz)+ N;
        String bin = toString(comp, 2, sz);
        String hex = toString(comp, 16, 0);

        StdOut.println(bin + " " + hex);
    }
}

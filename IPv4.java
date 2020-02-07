public class IPv4 {
    public static String address(long N) {
        long w = (N / (1 << 24)) % 256;
        long x = (N / (1 << 16)) % 256;
        long y = (N / (1 <<  8)) % 256;
        long z = (N / (1 <<  0)) % 256;
        return w + "." + x + "." + y + "." + z;
    }
    public static String address(String bin) {
        if (bin.length() == 0) return "";
        if (bin.length() == 8) return Integer.parseInt(bin, 2) + "";
        return Integer.parseInt(bin.substring(0, 8), 2) + "." + address(bin.substring(8));
    }
    public static long number(String address) {

        String[] wxyz = address.split("\\.");
        long w = (1 << 24) * Long.parseLong(wxyz[0]);
        long x = (1 << 16) * Long.parseLong(wxyz[1]);
        long y = (1 <<  8) * Long.parseLong(wxyz[2]);
        long z = (1 <<  0) * Long.parseLong(wxyz[3]);
        return w + x + y + z;
    }
    public static void main(String[] args) {
        String s = args[0];
        StdOut.println("IPv4 address: " + address(s));
    }
}

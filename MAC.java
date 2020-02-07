import java.util.Arrays;
public class MAC {
    public static long number(String address) {
        String[] hex = address.split(":");
        String s = "";
        for (String h: hex) s += h;
        return Long.parseLong(s, 16);
    }
    public static String address(long N) {
        String s = Long.toString(N, 16);
        String h = s.substring(s.length()-2);

        for (int i = s.length()-2; i > 0; i -= 2)
            h = s.substring(i-2, i) + ":" + h;
        return h;
    }
    public static void main(String[] args) {
        String add = args[0];

        long num = number(add);
        StdOut.println("MAC number : " + num);
        StdOut.println("MAC address: " + address(num));
    }
}

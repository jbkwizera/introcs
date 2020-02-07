public class BitsOp {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);

        StdOut.printf("compliment      : %10d\n", ~N);
        StdOut.printf("left shift      : %10d\n", N << d);
        StdOut.printf("right logical   : %10d\n", N >> d);
        StdOut.printf("right arithmetic: %10d\n", N >>> d);
    }
}

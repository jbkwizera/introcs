public class Scratch {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        pyramid(N);
    }
    public static void pyramid(int N) {
        for (int i = 1; i <= 2*N; i++) {
            for (int j = 0; j < Math.min(i, 2*N+1-i); j++)
                StdOut.print("*");
            StdOut.println();
        }
    }
}

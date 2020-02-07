public class LatinSquare {
    public static boolean rows(char[][] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            SET<Character> found = new SET<Character>();
            for (int j = 0; j < N; j++) {
                if (found.contains(a[i][j]))
                    return false;
                found.add(a[i][j]);
            }
        }
        return true;
    }
    public static boolean cols(char[][] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            SET<Character> found = new SET<Character>();
            for (int j = 0; j < N; j++) {
                if (found.contains(a[j][i]))
                    return false;
                found.add(a[j][i]);
            }
        }
        return true;
    }
    public static boolean reduced(char[][] a) {
        int N = a.length;
        for (int k = 1; k < N; k++)
            if (a[0][k] < a[0][k-1] || a[k][0] < a[k-1][0])
                return false;
        return true;
    }
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            int N = StdIn.readInt();
            char[][] a = new char[N][N];
            for (int i = 0; i < N; i++) {
                String s = StdIn.readString();
                for (int j = 0; j < N; j++)
                    a[i][j] = s.charAt(j);
            }
            if (rows(a) && cols(a)) {
                if (reduced(a)) StdOut.println("Reduced");
                else        StdOut.println("Not Reduced");
            }
            else  StdOut.println("No");
        }
    }
}

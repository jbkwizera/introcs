public class Rumor {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]); // max
        int T = Integer.parseInt(args[1]);

        double[] avgs = new double[M+1];
        for (int N = 2; N <= M; N++) {
            int sum = 0;
            int all = 0;
            for (int t = 0; t < T; t++) {
                boolean[] hh = new boolean[N];
                hh[0] = true;
                int prv = 0;
                int v = 1;
                while (true) {
                    int i = StdRandom.uniform(0, N);
                    if (i == prv) continue;
                    v++;
                    if (hh[i]) {
                        if (v >= N) all++;
                        //StdOut.printf("%2d tells %2d | tot %2d\n", prv, i, v-1);
                        v--;
                        break;
                    }
                    hh[i] = true;
                    //StdOut.printf("%2d tells %2d | tot %2d\n", prv, i, v);
                    prv = i;
                }
                //StdOut.println("---------------------");
                sum += v;
            }
            //StdOut.printf("avg for %2d = %5.2f\n", N, sum*1.0/T);
            avgs[N] = (sum*1.0/T)/N;
        }
        StdDraw.setXscale(-1, 1);
        StdDraw.setYscale(-1, 1);
        StdDraw.line(-1, 0, 1, 0);
        StdDraw.line(0, -1, 0, 1);



        for (int x = 3; x <= M; x++)
            StdDraw.line((x-1)*1.0/M, avgs[x-1], x*1.0/M, avgs[x]);
            //StdDraw.line(x*1.0/M, avgs[x]);
    }
}

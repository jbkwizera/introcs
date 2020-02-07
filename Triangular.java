import java.util.*;
public class Triangular {
    //static boolean[] isPrime = Prime.sieve(2000000);
    public static long primes(long N) {
        long n = N;
        ST<Long, Long> HT;
        HT = new ST<Long, Long>();
        for (long v = 2; v <= n/v; v++) {
            long count = 0;
            while (n % v == 0) {
                count++;
                n /= v;
            }
            if (count > 0) HT.put(v, count);
        }
        if (n > 1) {
            if (!HT.contains(n)) HT.put(n, 0L);
            HT.put(n, HT.get(n)+1);
        }
        long res = 1;
        for (long x: HT.keys())
            res *= (HT.get(x) + 1);
        return res;
    }
    public static void main(String[] args) {
        for (long i = 1; true; i++) {
            long N = (i*i + i) / 2;
            if (primes(N) == 450) {
                StdOut.println(N + "- " + i);
                break;
            }
        }
    }
}

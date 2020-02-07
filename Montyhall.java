
public class Montyhall {
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		int w1 = 0, w2 = 0;
		for (int i = 0; i < T; i++) {
			if (alg1()) w1++;
			if (alg2()) w2++;
		}
		StdOut.printf("%f\n", 1.0 * w1 / T);
		StdOut.printf("%f\n", 1.0 * w2 / T);
	}
	public static boolean alg1() {
		int pz = (int)(Math.random() * 3);
		int ch = (int)(Math.random() * 3);
		int sh;
		do {
			sh = (int)(Math.random() * 3);
		}
		while (sh == ch || sh == pz);
		ch = 3 -  ch - sh; 
		return ch == pz;
	}
	public static boolean alg2() {
		int pz = (int)(Math.random() * 3);
        int ch = (int)(Math.random() * 3);
		return pz == ch;
	}
}

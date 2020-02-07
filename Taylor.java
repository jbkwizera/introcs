public class Taylor {
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		StdOut.println("exp : "+Math.exp(x));
		StdOut.println("tylr: "+exp(x)+"\n");
		/*
		StdOut.println("sin : "+Math.sin(x));
		StdOut.println("tylr: "+sin(x)+"\n");

		StdOut.println("cos : "+Math.cos(x)); e^x e^2
		StdOut.println("tylr: "+cos(x));
		*/
	}
	public static double harmonic(double n) {
		double term = 1.0;
		double sum  = 0.0;
		for (int i = 2; term != 0.0; i++) {
			sum  += term;
			term /= i;
		}
		return sum;
	}
	public static double exp(double x) {
		double term = 1.0;
		double sum  = 0.0;
		for (int i = 1; term != 0.0; i++) {
			sum += term;
			term *= x/i;
		}
		return sum;
	}
	public static double sin(double x) {
		x = x % (2 * Math.PI);
		double term = 1.0;
		double sum  = 0.0;
		for (int i = 1; term != 0.0; i++) {
			term *= x/i;
			if (i % 4 == 1) sum += term;
			if (i % 4 == 3) sum -= term;
		}
		return sum;
	}
	public static double cos(double x) {
		x = x % (2 * Math.PI);
		double term = 1.0;
		double sum  = 1.0;
		for (int i = 1; term != 0.0; i++) {
			term *= x/i;
			if (i % 4 == 0)	sum += term;
			if (i % 4 == 2)	sum -= term;
		}
		return sum;
	}
}

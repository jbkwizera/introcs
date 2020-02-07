public class DoublingTest {
	public static double timeTrial(long N) {
		Stopwatch s = new Stopwatch();
		String cnt = Scratch.st1(N);
		return s.elapsedTime();
	}
	public static void main(String[] args) {
		double prev = timeTrial(2);
		for (long N = 4; true; N *= N) {
			double curr = timeTrial(N); 
			StdOut.printf("%7d %4.2f\n", N, curr/prev); 
			prev = curr;
		} 
	}
}

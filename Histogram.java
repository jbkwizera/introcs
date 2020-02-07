public class Histogram {
	private final double[] freq;
	private double max;

	public Histogram(int N)
	{	freq = new double[N];    }

	public void addDataPoint(int i) {
		freq[i]++;
		if (freq[i] > max) max = freq[i];
	}
	public void draw() {
		StdDraw.setYscale(0, max);
		StdStats.plotBars(freq);
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		Histogram ht = new Histogram(N+1);
		for (int t = 0; t < T; t++) {
			int v = Bernoulli.binomial(N);
			ht.addDataPoint(v);
		}
		StdDraw.setCanvasSize(500, 100);
		ht.draw();
	}
}

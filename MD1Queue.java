public class MD1Queue {
	public static void main(String[] args) {
		double lambda = Double.parseDouble(args[0]);
		double mu     = Double.parseDouble(args[1]);
		Histogram ht  = new Histogram(60 + 1);
		Queue<Double> q = new Queue<Double>();
		double nextArrival = StdRandom.exp(lambda);
		double nextService = nextArrival + 1/mu;

		while (true) {
			while (nextArrival < nextService) {
				q.enqueue(nextArrival);
				nextArrival += StdRandom.exp(lambda);
			}
			double wait = nextService - q.dequeue();
			StdDraw.clear();
			ht.addDataPoint(Math.min(60, (int) (wait)));
			ht.draw();
			StdDraw.show(20);
			if (q.isEmpty()) nextService = nextArrival + 1/mu;
			else			 nextService = nextService + 1/mu;
		}
	}
}

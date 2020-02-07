public class LoadBalance {
	public static void main(String[] args) {
		// assign N items to M servers using
		// shortest-in-a-sample (of size S) policy.
		int M = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		int S = Integer.parseInt(args[2]);
		
		// create server queues
		RandomQueue<Queue<Integer>> servers;
		servers = new RandomQueue<Queue<Integer>>();
		for (int i = 0; i < M; i++)
			servers.enqueue(new Queue<Integer>());
		
		for (int j = 0; j < N; j++) {
			Queue<Integer> min = servers.sample();
			for (int k = 1; k < S; k++) {
				Queue<Integer> q = servers.sample();
				if (q.size() < min.size()) min = q;
			}
			min.enqueue(j);
		}
		int i = 0;
		double[] sizes = new double[M];
		for (Queue<Integer> q: servers)
			sizes[i++] = q.size();
			
		StdDraw.setYscale(0, 2.0*N/M);
		StdStats.plotBars(sizes);
	}
}

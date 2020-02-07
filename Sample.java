public class Sample {
	public static void main(String[] args) {
		// random sample of M integers from 
		// 0 ... N-1 (no duplicates). 
		int M = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		int[] perm = new int[N];

		for (int i = 0; i < N; i++)
			perm[i] = i;

		for (int i = 0; i < M; i++) {
			int r = i + (int) (Math.random() * (N-i));
			int temp = perm[r];
			perm[r] = perm[i];
			perm[i] = temp;
		}

		for (int i = 0; i < M; i++)
			StdOut.print(perm[i] + " ");
		StdOut.println();
	}
}

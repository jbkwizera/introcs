public class Bernoulli {
	public static int binomial(int N) {
		int heads = 0;
		for (int i = 0; i < N; i++)
			if (StdRandom.bernoulli(0.5)) heads++;
		return heads;
	}
	public static void main(String[] args) {
	}
}

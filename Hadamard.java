
public class Hadamard {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		boolean[][] h = eval(N);
		StdArrayIO.print(h);
	}
	public static boolean[][] eval(int N) {
		boolean[][] hadamard = new boolean[N][N];
		hadamard[0][0] = true;
		
		for (int h = 1; h < N; h += h) { 
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < h; j++) {
					hadamard[i+h][j]   = hadamard[i][j];
					hadamard[i][j+h]   = hadamard[i][j];
					hadamard[i+h][j+h] =!hadamard[i][j];
				}
			}
		}
		return hadamard;						
	}
}
		



public class RandomWalk {
	public static void main(String[] args) {     
		int N = Integer.parseInt(args[0]);
		walk(N);
	}
	private static void initialize(int N) {
		StdDraw.setPenColor(StdDraw.GRAY);
		double s = 1.0 /(N - N % 2);
		
		for (double y = 0; y <= 1.0; y += s) 
			StdDraw.line(0, y, 1, y);
		
		for (double x = 0; x <= 1.0; x += s)
			StdDraw.line(x, 0, x, 1);
		

		StdDraw.setPenRadius(0.02);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.point((N/2)*s, (N/2)*s);
		
		StdDraw.setPenRadius(0.005);
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
	}
	public static void walk(int N) {
	
		boolean[][] v = new boolean[N][N];
		int x = N/2, y = N/2;
		
		initialize(N);
		double s = 1.0 / (N - N % 2);
		double px0 = (N/2) * s, py0 = px0;
		double px  = px0, py  = px0;
		
		while (x > 0 && x < N-1 && y > 0 && y < N-1) {
			boolean tv = v[x][y];
			v[x][y] = true;	
			if (v[x-1][y] && v[x+1][y] && v[x][y-1] && v[x][y+1]) {
				StdOut.println("Dead End");
				break;
			}
			if (!tv) {
				StdDraw.line(px0, py0, px, py);
				px0 = px; py0 = py;
			}
			
			double d = Math.random(); 
			if 	(d < 0.25) { 
				if (!v[x-1][y]){
					x--; py += s; 
					StdOut.println("North");
				}
			}
			else if 	(d < 0.50) { 
				if (!v[x][y+1]){
					y++; px += s; 
					StdOut.println("East");
				}
			}
			else if 	(d < 0.75) { 
				if (!v[x+1][y]){
					x++; py -= s;
					StdOut.println("South"); 
				}
			}
			else { 
				if (!v[x][y-1]){
					y--; px -= s; 
					StdOut.println("West");
				}
			}
		}
		StdDraw.line(px0, py0, px, py);
	}
}





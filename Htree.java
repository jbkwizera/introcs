public class Htree {
	public static void draw(int N, double sz, double x, double y) {
		if (N == 0) return;
		double x0 = x - sz/2, x1 = x + sz/2;  //   N   depth
		double y0 = y - sz/2, y1 = y + sz/2;  //  sz   line length
		StdDraw.line(x0,  y, x1,  y);         // x, y  center
		StdDraw.line(x0, y0, x0, y1);
		StdDraw.line(x1, y0, x1, y1);
		draw(N-1, sz/2, x0, y0);
		draw(N-1, sz/2, x0, y1);
		draw(N-1, sz/2, x1, y0);
		draw(N-1, sz/2, x1, y1);
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		StdDraw.setPenRadius(0.005);
		draw(N, 0.5, 0.5, 0.5);
	}
}

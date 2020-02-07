public class Ruler {
	public static String ruler(int N) {
		if (N == 0) return "";
		return ruler(N-1) + N + ruler(N-1);
	}
	public static void ruler(int N, String r) {
		double cnt = Math.pow(2, N) - 1;
		double sx  = 1.0 / (cnt + 2);
		double sy  = 1.0 / (8*N + 2);
		
		StdDraw.setCanvasSize(1024, 512);
		StdDraw.setXscale(0, 1.0 + sx);
		StdDraw.setYscale(0, 1.0 + sy);
		StdDraw.line(sx, sy, cnt*sx, sy);
		for (int i = 0; i < r.length(); i++) {
			int ch = r.charAt(i) - '0';
			double x = sx * (i + 1);
			double y = sy + sy * ch;
			StdDraw.line(x, sy, x, y);
		}			
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		String r = ruler(N);
		ruler(N, r);
		
		// Tn = Tn/2 + 1     
	}
}

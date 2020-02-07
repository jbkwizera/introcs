
public class Dragon {
	public static String next(String s) {
		String t = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'R') 		t = 'L' + t;
			else if (c == 'L')	t = 'R' + t;
			else				t = 'F' + t;
		}
		s = s + 'L' + t;
		return s;
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		String s = "F";
		for (int i = 1; i < N; i++)
			s = next(s);

		Draw dragon = new Draw("Dragon");
		dragon.setCanvasSize(1000, 960);
		dragon.filledSquare(0.5, 0.5, 0.5);
		dragon.setPenColor(2, 40, 255);
		double x0 = 0.7, y0 = 0.7;
		double x = 0.71, y = 0.7;
		dragon.line(x0, y0, x, y);

		int cl = 1;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if 		(c == 'F') {
				dragon.line(x0, y0, x, y);
				switch(cl) {
					case 1: dragon.setPenColor(dragon.WHITE); 	break;
					case 2: dragon.setPenColor(dragon.RED); 	break;
					case 3: dragon.setPenColor(dragon.BLUE);	break;
					case 4: dragon.setPenColor(dragon.GREEN);	break;
					case 5: dragon.setPenColor(dragon.ORANGE);	break;
					case 6: dragon.setPenColor(dragon.GRAY);	break;
					case 7: dragon.setPenColor(dragon.YELLOW);	break;
					case 8: dragon.setPenColor(dragon.MAGENTA);	break;
				}
				cl++;
				if (cl == 9) cl = 1;
			}
			else if (c == 'R') {
				double tx = x, ty = y;
				if 		(x > x0) y -= 0.005; // right down
				else if (x < x0) y += 0.005; // left up
				else if (y > y0) x += 0.005; // up right
				else if (y < y0) x -= 0.005; // down left
				x0 = tx; y0 = ty;
			}
			else if (c == 'L') {
				double tx = x, ty = y;
				if 		(x > x0) y += 0.005; // right up
				else if (x < x0) y -= 0.005; // left down
				else if (y > y0) x -= 0.005; // up left
				else if (y < y0) x += 0.005; // down right
				x0 = tx; y0 = ty;
			}
		}
	}
}

public class Calendar {
	public static boolean isLeapYear(int N) {
		boolean isLeapYear = (N % 4 == 0);
		isLeapYear = isLeapYear && (N % 100 != 0);
		isLeapYear = isLeapYear || (N % 400 == 0);
		return isLeapYear;
	}
	public static int firstDay(int m, int y) {
		int d = 1;
		int y0 = y - (14 - m) / 12;
		int x  = y0 + y0/4 - y0/100 + y0/400;
		int m0 = m + 12 * ((14 - m)/12) - 2;
		int d0 = (d + x + (31 * m0)/12) % 7;

		return d0;
	}
	public static void headers(int m, int y) {
		String[] mm = {"", "January", "February", "March", "April",
			    	   "May", "June", "July", "August", "September",
				   	   "October", "November", "December"};
		String[] dd = {"S", "M", "T", "W", "T", "F", "S"};

		String h = mm[m] + " " + y;
		int N    = h.length();
		int w    = (20 - N) / 2;
		String f = "%" + (w + N) + "s\n";

		StdOut.printf(f, h);
		for (String day: dd)
			StdOut.printf("%2s ", day);
		StdOut.println();
	}
	public static void show(int m, int y) {
		int[] mxd = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (isLeapYear(y))	mxd[2] = 29;

		headers(m, y);
		int x = firstDay(m, y);
		for (int i = 0; i < x; i++)
			StdOut.print("   ");
		for (int i = 1; i <= mxd[m]; i++) {
			if (x > 0 && x % 7 == 0)
				StdOut.println();
			StdOut.printf("%2d ", i);
			x++;
		}
		StdOut.println();
	}
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		show(m, y);
	}
}

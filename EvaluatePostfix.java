public class EvaluatePostfix {
	public static boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") ||
			   s.equals("*") || s.equals("/") ||
			   s.equals("sqrt");
	}
	public static double eval(String s) {
		Stack<Double> opds = new Stack<Double>();
		String[] a = s.split("\\s+");
		for (int i = 0; i < a.length; i++) {
			String t = a[i];
			double v;
			if 		(t.equals("(") || t.equals(")"))	 continue;
			else if	(!isOperator(t))	 v = Double.parseDouble(t);
			else {
				v = opds.pop();
				if 		(t.equals("+"))		v = opds.pop() + v;
				else if (t.equals("-")) 		v = opds.pop() - v;
				else if (t.equals("*"))		v = opds.pop() * v;
				else if (t.equals("/"))		v = opds.pop() / v;
				else if (t.equals("sqrt"))	v = Math.sqrt(v);
			}
			opds.push(v);
		}
		return opds.pop();
	}
	public static void main(String[] args) {
		String s = StdIn.readAll();
		StdOut.println(eval(s));
	}
}
				
				
				

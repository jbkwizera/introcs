public class EvaluateInfix {
	public static double eval(String s) {
		Stack<String> opts = new Stack<String>();
		Stack<Double> opds = new Stack<Double>();
		
		String[] a = s.split("\\s+");
		for (int i = 0; i < a.length; i++) {
			String t = a[i];
			if 		(t.equals("("))		            ;
			else if (t.equals("+")) 		opts.push(t);
			else if (t.equals("-")) 		opts.push(t);
			else if (t.equals("*")) 		opts.push(t);
			else if (t.equals("/")) 		opts.push(t);
			else if (t.equals("sqrt"))	opts.push(t);
			else if (t.equals(")")) {
				String op = opts.pop();
				double v  = opds.pop();
				if 		(op.equals("+"))		v = opds.pop() + v;
				else if (op.equals("-"))		v = opds.pop() - v;
				else if (op.equals("*"))		v = opds.pop() * v;
				else if (op.equals("/")) 		v = opds.pop() / v;
				else if (op.equals("sqrt")) 	v = Math.sqrt(v);
				opds.push(v);
			}
			else opds.push(Double.parseDouble(t));
		}
		return opds.pop();	
	}
	public static void main(String[] args) {
		String s = StdIn.readAll();
		StdOut.println(eval(s));
	}
}

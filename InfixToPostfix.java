public class InfixToPostfix {
	public static boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") ||
		s.equals("*") || s.equals("/") || s.equals("%");
	}
	public static void main(String[] args) {
	
		Stack<String> opts = new Stack<String>();
		Stack<String> opds = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if 		(s.equals("("))  ;
			else if 	(isOperator(s))	opts.push(s);
			else if 	(s.equals(")")) {
				String b = opds.pop();
				String a = opds.pop();
				String o = opts.pop(); 
				String v = "( " + a + " " + b + " " + o + " )";
				opds.push(v);
			}
			else opds.push(s);
		}
		// 1 2 3 + 4 5 * * +
		// postfix notation expression
		StdOut.println(opds);
		// 1 2 + 3 4 - 5 6 - * *
	}
}

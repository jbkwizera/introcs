
public class Fraction {
	private int num;
	private int den;
	public Fraction(int num, int den) {
		if (den == 0) throw new ArithmeticException("/ by 0");
		this.num = num;
		this.den = den;
	}
	public Fraction(int num) {
		this.num = num;
		this.den = 1;
	}
	public int num() { return num; } 
	public int den() { return den; }
	public void setNum(int num) {
		this.num = num;
	}
	public void setDen(int den) {
		this.den = den;
	}
	// add f to this
	public Fraction add(Fraction f) {
		int v = num*f.den() + den*f.num();
		int w = den*f.den();
		Fraction tem = new Fraction(v, w);
		tem = reduce(tem);
		return tem;
	}
	// subtract f from this
	public Fraction subtract(Fraction f) {
		int v = num*f.den() - den*f.num();
		int w = den*f.den();
		Fraction tem = new Fraction(v, w);
		tem = reduce(tem);
		return tem;
	}
	// multiply this by f 
	public Fraction multiply(Fraction f) {
		int v = num*f.num();
		int w = den*f.den();
		Fraction tem = new Fraction(v, w);
		tem = reduce(tem);
		return tem;
	}
	
	// divide this by f 
	public Fraction divide(Fraction f) {
		int v = num*f.den();
		int w = den*f.num();
		Fraction tem = new Fraction(v, w);
		tem = reduce(tem);
		return tem;
	}
	
	// reduce a fraction using gcd
	private Fraction reduce(Fraction f) {
		int v = f.num();
		int w = f.den();
		int g = gcd(v, w);
		v = v / g;
		w = w / g;
		Fraction tem = new Fraction(v, w);
		return tem;
	}
	
	// find gcd to reduce a fraction
	private int gcd(int v, int w) {
		if (w == 0) return v; 
		return gcd(w, v % w);
	}
	
	// return to string
	public String toString() {
		Fraction this_ = reduce(this);
		int sign1 = Math.abs(this_.num()) / this_.num();
		int sign2 = Math.abs(this_.den()) / this_.den();
		int sign  = sign1 * sign2;
		
		if (this_.den() == 1) 
			return (sign * this_.num()) + "";
		return (sign * this_.num()) + "/" + 
			    Math.abs(this_.den());
	}
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		int den = Integer.parseInt(args[1]);
		
		Fraction f = new Fraction(num, den);
		StdOut.println(f);
		
		Fraction g = new Fraction(den, num);
		StdOut.println(f.add(g));
		StdOut.println(f.subtract(g));
		StdOut.println(f.multiply(g));
		StdOut.println(f.divide(g));
	}
}







public class DoublingStackOfStrings {
	private String[] a = new String[1];
	private int N = 0;
	
	public int size() { return N; }
	public boolean isEmpty() {
		return N == 0;
	}
	private void resize(int max) {
		String[] temp = new String[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}

	public void push(String item) {
		if (N == a.length) resize(2*a.length);
		a[N++] = item;
	}

	public String pop() {
		String item = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length/4) resize(a.length/2);
		return item;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < N; i++)
			s += a[i] + " ";
		return s;
	}
	public static void main(String[] args) {
	
	}
}

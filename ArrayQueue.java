
import java.util.NoSuchElementException;
public class ArrayQueue<Item> {
	private Item[] a = (Item[]) new Object[1];
	private int M = 0;
	private int N = 0;

	public boolean isEmpty() { 	return N - M == 0;	}
	public int size() 		 {	return N - M;		}

	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = M; i < N; i++) //
			temp[i-M] = a[i];
		N = N - M;
		a = temp;
		M = 0;
	}
	public void enqueue(Item item) {
		if (N == a.length) resize(2*size());
		a[N++] = item;
	}

	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException();
		Item item = a[M++];
		a[M-1] = null;
		if (size() > 0 && size() == a.length/4)
			resize(a.length/2);
		return item;
	}
	public String toString() {
		String s = "";
		for (int i = M; i < N; i++)
			s += a[i] + " ";
		return s;
	}
	public static void main(String[] args) {
		ArrayQueue<String> q = new ArrayQueue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				q.enqueue(item);
			else if (!q.isEmpty())
				StdOut.print(q.dequeue() + " ");
		}
		StdOut.println("(" + q.size() + " left on queue)");
	}
}

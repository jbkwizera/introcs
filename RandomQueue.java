import java.util.NoSuchElementException;
import java.util.Iterator;
public class RandomQueue<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	
	public int size()       {   return N;       }
	public boolean isEmpty(){   return N == 0;  }
	
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}
	public void enqueue(Item item) {
		if (N == a.length) resize(2*a.length);
		a[N++] = item;
	}
	public Item dequeue() {
	    if (N == 0)
	        throw new NoSuchElementException("queue is empty.");
		int r = StdRandom.uniform(N);
		Item item = a[r];
		a[r] = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length/4) resize(a.length/2);
		return item;
	}
	public Item sample() {
	    if (N == 0)
	        throw new NoSuchElementException("queue is empty.");
		int r = StdRandom.uniform(N);
		return a[r];
	}
	public String toString() {
		String s = "";
		for (Item item: this) s += item + " ";
		return s;
	}
	private Item[] shuffle(Item[] a) {
		Item[] temp = (Item[]) new Object[N];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		
		for (int i = 0; i < N; i++) {
			int r = i + StdRandom.uniform(N-i);
			Item v  = temp[r];
			temp[r] = temp[i];
			temp[i] = v;
		}
		return temp;
	}
	private class ArrayIterator implements Iterator<Item> {
		private int i = 0;
		private Item[] temp = shuffle(a);
		public boolean hasNext() {
			return i < N; 
		}
		public Item next() {
			return temp[i++];
		}
		public void remove() { }
	}
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
	public static void main(String[] args) {
		RandomQueue<String> rq;
		rq = new RandomQueue<String>();
		
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			rq.enqueue(s);
		}
		for (String s: rq)
			StdOut.println(s);
	}
}
	

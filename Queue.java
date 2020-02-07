import java.util.NoSuchElementException;
import java.util.Iterator;
public class Queue<Item> implements Iterable<Item> {
	private Node first; // first in
	private Node last;  // last  in
	private int N;

	public Queue() {}
	public Queue(Queue<Item> q) {
		for (Item item: q)	enqueue(item);
	}
	private class Node {
		Item item;
		Node next;
	}
	public int size()		{	return N;		}
	public boolean isEmpty(){	return N == 0;	}

	// add to the last in item
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		if (N == 0)	 first = last;
		else  oldlast.next = last;
		N++;
	}
	// first in first out: FIFO
	// inward: first –––> last
	public Item dequeue() {
		if (N == 0) throw new NoSuchElementException("queue is empty.");
		Item item = first.item;
		first = first.next;
		N--;
		if (N == 0) last = null;
		return item;
	}
	public String toString() {
		String s = "";
		for (Item item: this) s += item + " ";
		return s;
	}
	private class ListIterator implements Iterator<Item> {
		Node current = first;
		public boolean hasNext() {
			return current != null;
		}
		public Item next() {
			Item item = current.item;
			current   = current.next;
			return item;
		}
		public void remove() { }
	}
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))	q.enqueue(item);
			else if (!q.isEmpty())	StdOut.print(q.dequeue() + " ");
		}
		StdOut.println("(" + q.size() + " left on queue)");
	}
}

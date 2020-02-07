import java.util.NoSuchElementException;
import java.util.Iterator;
public class Stack<Item> implements Iterable<Item> {
	private Node last; // last added
	private int N;

	public Stack() { }
	public Stack(Stack<Item> s) {
		int N = s.size();
		Item[] temp = (Item[]) new Object[N];
		for (int i  = 0; i < N; i++)
			temp[i] = s.pop();

		for (int i  = 0; i < N; i++) {
			s.push(temp[N-i-1]);
			push(temp[N-i-1]);
		}
	}
	private class Node {
		Item item;
		Node next;
	}
	public int size() 		{	return N;		}
	public boolean isEmpty(){	return N == 0;	}

	// add to the last in item
	public void push(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = oldlast;
		N++;
	}
	// last in last out: LIFO
	// outward: last –––> first
	public Item pop() {
		if (N == 0) throw new NoSuchElementException("stack is empty.");
		Item item = last.item;
		last = last.next;
		N--;
		return item;
	}
	public Item peek() {
		if (N == 0) throw new NoSuchElementException("stack is empty.");
		return last.item;
	}
	public String toString() {
		String s = "";
		for (Item item: this) s += item + " ";
		return s;
	}
	private class ListIterator implements Iterator<Item> {
		Node current = last;
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
		Stack<String> s = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))	s.push(item);
			else if (!s.isEmpty())	StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}

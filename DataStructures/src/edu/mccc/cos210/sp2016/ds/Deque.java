package edu.mccc.cos210.sp2016.ds;

public class Deque<E> implements IDeque<E> {
	private IList<E> theList = new List<>();
	@Override
	public void enqueueFirst(E data) {
		theList.addFirst(data);
	}
	@Override
	public void enqueueLast(E data) {
		theList.addLast(data);
	}
	@Override
	public E peekFirst() {
		return theList.getFirst();
	}
	@Override
	public E peekLast() {
		return theList.getLast();
	}
	@Override
	public E dequeueFirst() {
		return theList.removeFirst();
	}
	@Override
	public E dequeueLast() {
		return theList.removeFirst();
	}
	@Override
	public int getSize() {
		return theList.getSize();
	}
	@Override
	public boolean isEmpty() {
		return theList.isEmpty();
	}
	@Override
	public String toString() {
		return theList.toString();
	}
}

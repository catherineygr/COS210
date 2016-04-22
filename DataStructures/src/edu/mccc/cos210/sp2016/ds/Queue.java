package edu.mccc.cos210.sp2016.ds;

public class Queue<E> implements IQueue<E> {
	private IList<E> theList = new List<>();
	@Override
	public void enqueue(E data) {
		theList.addFirst(data);
	}
	@Override
	public E peek() {
		return theList.getLast();
	}
	@Override
	public E dequeue() {
		return theList.removeLast();
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

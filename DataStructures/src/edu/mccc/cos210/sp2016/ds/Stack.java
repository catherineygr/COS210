package edu.mccc.cos210.sp2016.ds;

public class Stack<E> implements IStack<E> {
	private IForwardList<E> theList = new ForwardList<>();
	@SuppressWarnings("unused")
	private int size = 0;
	@Override
	public void push(E data) {
		theList.addFirst(data);
	}
	@Override
	public E peek() {
		return theList.getFirst();
	}
	@Override
	public void pop() {
		theList.removeFirst();
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

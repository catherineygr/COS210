package edu.mccc.cos210.sp2016.ds;

public interface IDeque<E> {
	public void enqueueFirst(E data);
	public void enqueueLast(E data);
	public E peekFirst();
	public E peekLast();
	public E dequeueFirst();
	public E dequeueLast();
	public int getSize();
	public boolean isEmpty();
}

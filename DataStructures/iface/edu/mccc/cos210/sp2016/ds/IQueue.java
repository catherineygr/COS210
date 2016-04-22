package edu.mccc.cos210.sp2016.ds;

public interface IQueue<E> {
	public void enqueue(E data);
	public E peek();
	public E dequeue();
	public int getSize();
	public boolean isEmpty();
}

package edu.mccc.cos210.sp2016.ds;

public interface IForwardList<E> extends Iterable<E> {
	public void addFirst(E data);
	public E getFirst();
	public E removeFirst();
	public boolean contains(E data);
	public int getSize();
	public boolean isEmpty();
}

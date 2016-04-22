package edu.mccc.cos210.sp2016.ds;

public interface IList<E> extends Iterable<E> {
	public void add(E data);
	public void addFirst(E data);
	public void addLast(E data);
	public E getFirst();
	public E getLast();
	public E removeFirst();
	public E removeLast();
	public boolean contains(E data);
	public int getSize();
	public boolean isEmpty();
	public java.util.Iterator<E> reverseIterator();
}

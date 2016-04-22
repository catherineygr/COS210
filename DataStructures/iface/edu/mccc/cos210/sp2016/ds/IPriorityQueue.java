package edu.mccc.cos210.sp2016.ds;

public interface IPriorityQueue<E extends Comparable<E>> {
	public void insert(E element);
	public E peekTop() throws java.util.NoSuchElementException;
	public E getTop() throws java.util.NoSuchElementException;
	public int getSize();
	public boolean isEmpty();
}

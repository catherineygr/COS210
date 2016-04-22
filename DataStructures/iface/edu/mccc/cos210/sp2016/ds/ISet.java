package edu.mccc.cos210.sp2016.ds;

public interface ISet<E> extends Iterable<E> {
	public void add(E data);
	public void add(ISet<E> set);
	public void remove(E data);
	public boolean contains(E data);
	public boolean contains(ISet<E> set);
	public ISet<E> union(ISet<E> set);
	public ISet<E> intersection(ISet<E> set);
	public ISet<E> difference(ISet<E> set);
	public int getSize();
	public boolean isEmpty();
}

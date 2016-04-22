package edu.mccc.cos210.sp2016.ds;

public interface IArray<E> extends Iterable<E> {
	public E get(int index);
	public void set(int index, E data);
	public int getSize();
}

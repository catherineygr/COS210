package edu.mccc.cos210.sp2016.ds;

public interface IVector<E> extends IArray<E> {
	public void pushBack(E data);
	public void popBack();
	public E back();
	public int getCapacity();
	public void shrinkToFit();
}

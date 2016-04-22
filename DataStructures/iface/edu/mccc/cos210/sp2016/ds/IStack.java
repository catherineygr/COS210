package edu.mccc.cos210.sp2016.ds;

public interface IStack<E> {
	public void push(E data);
	public E peek();
	public void pop();
	public boolean isEmpty();
}

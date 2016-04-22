package edu.mccc.cos210.sp2016.ds;

import java.util.Iterator;

public class Array<E> implements IArray<E> {
	private final boolean DEBUG;
	private Object[] theArray = null;
	public Array(int size) {
		this(size, false);
	}
	public Array(int size, boolean debug) {
		theArray = new Object[size];
		DEBUG = debug;
	}
	@Override
	public E get(int index) {
		return (E) theArray[index];
	}
	@Override
	public void set(int index, E data) {
		theArray[index] = data;
	}
	@Override
	public int getSize() {
		return theArray.length;
	}
	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}
	private class ArrayIterator implements java.util.Iterator<E> {
		private int nextIndex = 0;
		@Override
		public boolean hasNext() {
			return nextIndex < getSize();
		}
		@Override
		public E next() {
			return get(nextIndex++);
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (int i = 0; i < getSize(); i++) {
			sb.append(get(i).toString() + " ");
		}
		sb.append("]");
		return sb.toString();
	}
}

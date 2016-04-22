package edu.mccc.cos210.sp2016.ds;

public class Vector<E> implements IVector<E> {
	@SuppressWarnings("unused")
	private final boolean DEBUG;
	private Object[] theArray = null;
	private int size = 0;
	private int capacity;
	public Vector() {
		this(0, 1);
	}
	public Vector(int size) {
		this(size, size);
	}
	public Vector(int size, int capacity) {
		this(size, capacity < size ? size : capacity, false);
	}
	public Vector(int size, int capacity, boolean debug) {
		this.size = size;
		this.capacity = capacity < size ? size : capacity;
		theArray = new Object[capacity];
		DEBUG = debug;
	}
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		checkBounds(index);
		return (E) theArray[index];
	}
	@Override
	public void set(int index, E data) {
		checkBounds(index);
		theArray[index] = data;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public void pushBack(E data) {
		if (size == capacity) {
			capacity *= 2;
			Object[] newArray = new Object[capacity];
			for (int i = 0; i < theArray.length; i++) {
				newArray[i] = theArray[i];
			}
			theArray = newArray;
		}
		theArray[size++] = data;
	}
	@Override
	public void popBack() {
		checkBounds(size - 1);
		theArray[size - 1] = null;
		size--;
	}
	@SuppressWarnings("unchecked")
	@Override
	public E back() {
		E data = (E) theArray[size - 1];
		return data;
	}
	@Override
	public int getCapacity() {
		return capacity;
	}
	@Override
	public void shrinkToFit() {
		Object[] newArray = new Object[size];
		for (int i = 0; i < theArray.length; i++) {
			if (theArray[i] != null)
				newArray[i] = theArray[i];
		}
		capacity = size;
		theArray = newArray;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getSize() + " " + getCapacity() + " ");
		sb.append("[ ");
		for (int i = 0; i < getSize(); i++) {
			sb.append(get(i).toString() + " ");
		}
		sb.append("]");
		return sb.toString();
	}
	@Override
	public java.util.Iterator<E> iterator() {
		return new VectorIterator();
	}
	private class VectorIterator implements java.util.Iterator<E> {
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
	private void checkBounds(int index) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
	}
}

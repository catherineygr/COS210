package edu.mccc.cos210.sp2016.ds;


public class VectorOnArray<E> implements IVector<E> {
	@SuppressWarnings("unused")
	private final boolean DEBUG;
	IArray<E> theArray = null;
	private int size = 0;
	private int capacity;
	public VectorOnArray() {
		this(0, 1);
	}
	public VectorOnArray(int size) {
		this(size, size);
	}
	public VectorOnArray(int size, int capacity) {
		this(size, capacity < size ? size : capacity, false);
	}
	public VectorOnArray(int size, int capacity, boolean debug) {
		this.size = size;
		this.capacity = capacity < size ? size : capacity;
		theArray = new Array<E>(capacity);
		DEBUG = debug;
	}
	@Override
	public E get(int index) {
		checkBounds(index);
		return (E) theArray.get(index);
	}
	@Override
	public void set(int index, E data) {
		checkBounds(index);
		theArray.set(index, data);
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public void pushBack(E data) {
		if (size == capacity) {
			capacity *= 2;
			IArray<E> newArray = new Array<E>(capacity);
			for (int i = 0; i < theArray.getSize(); i++) {
				newArray.set(i, theArray.get(i));
			}
			theArray = newArray;
		}
		theArray.set(size++, data);
	}
	@Override
	public void popBack() {
		checkBounds(size - 1);
		theArray.set(size - 1, null);
		size--;
	}
	@Override
	public E back() {
		E data = (E) theArray.get(size - 1);
		return data;
	}
	@Override
	public int getCapacity() {
		return capacity;
	}
	@Override
	public void shrinkToFit() {
		IArray<E> newArray = new Array<E>(size);
		for (int i = 0; i < theArray.getSize(); i++) {
			if (theArray.get(i) != null)
				newArray.set(i, theArray.get(i));
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
		return new VectorOnArrayIterator();
	}
	private class VectorOnArrayIterator implements java.util.Iterator<E> {
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

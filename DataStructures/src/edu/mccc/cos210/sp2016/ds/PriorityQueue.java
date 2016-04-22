package edu.mccc.cos210.sp2016.ds;

public class PriorityQueue<E extends Comparable<E>> implements IPriorityQueue<E> {
	private Vector<E> theVector = new Vector<>(0, 1);
	private int size = 0;
	public PriorityQueue() {
	}
	@Override
	public void insert(E element) {
		theVector.pushBack(element);
		size++;
		bubbleUp();
	}
	@Override
	public E peekTop() throws java.util.NoSuchElementException {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		return theVector.get(0);
	}
	@Override
	public E getTop() throws java.util.NoSuchElementException {
		E top = null;
		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		top = theVector.get(0);
		theVector.set(0, null);
		size--;
		if (!isEmpty()) {
			theVector.set(0, theVector.get(size));
		}
		theVector.popBack();
		bubbleDown();
		return top;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	private void bubbleUp() {
		for (int i = size - 1; !isRoot(i); i = getParentIndex(i)) {
			if (getValue(i).compareTo(getParentValue(i)) > 0) {
				break;	
			}
			E temp = getParentValue(i);
			theVector.set(getParentIndex(i), getValue(i));
			theVector.set(i, temp);
			
		}
	}
	private void bubbleDown() {
		for (int i = 0; !isLeaf(i);) {
			int j = getMinimumChildIndex(i);
			if (
				getValue(i).compareTo(getValue(j)) <= 0) {
				break;
				}
			E temp = getValue(j);
			theVector.set(j, getValue(i));
			theVector.set(i, temp);
			i = j;
			
		}
	
		
	}
	private boolean isRoot(int index) {
		return index == 0;
	}
	private boolean isLeaf(int index) {
		int leftIndex = getLeftChildIndex(index);
		int rightIndex = getRightChildIndex(index);
		return leftIndex >= size && rightIndex >= size;
	}
	private E getValue(int index) {
		return theVector.get(index);
	}
	private E getParentValue(int index) throws IllegalArgumentException {
		if (isRoot(index)) {
			throw new IllegalArgumentException();
		}
		return theVector.get(getParentIndex(index));
	}
	private int getParentIndex(int index) {
		return (index - 1)/ 2;
	}
	private int getLeftChildIndex(int index) {
		return index * 2 + 1;
	}
	private int getRightChildIndex(int index) {
		return index * 2 + 2;
	}
	private int getMinimumChildIndex(int index) {
		int leftIndex = getLeftChildIndex(index);
		E leftValue = getValue(leftIndex);
		int rightIndex = getRightChildIndex(index);
		int minChildIndex = leftIndex;
		if (rightIndex < theVector.getSize()) {
			E rightValue = getValue(rightIndex);
			if (rightValue != null && leftValue.compareTo(rightValue) > 0) {
				minChildIndex = rightIndex;
			}
		}
		return minChildIndex;
	}
	@Override
	public String toString() {
		String s = theVector.toString();
		return s.substring(s.indexOf("["));
	}
	boolean isHeap() {
		boolean heap = true;
		for (int i = size - 1; i > 0;i--) {
				if (getValue(i).compareTo(getValue(getParentIndex(i))) < 0) {
					heap = false;
					break;
			}
		}
		return heap;
		
	}
}

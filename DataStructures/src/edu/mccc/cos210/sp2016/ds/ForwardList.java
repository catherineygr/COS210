package edu.mccc.cos210.sp2016.ds;

public class ForwardList<E> implements IForwardList<E> {
	@SuppressWarnings("unused")
	private final boolean DEBUG;
	private SinglyLinkedList<E> theList;
	public ForwardList() {
		this(false);
	}
	public ForwardList(boolean debug) {
		this.theList = new SinglyLinkedList<E>(debug);
		DEBUG = debug;
	}
	@Override
	public void addFirst(E data) {
		theList.addFirst(theList.new SinglyLinkedListNode(data));
	}
	@Override
	public E getFirst() {
		if (theList.isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		return theList.getHead().getData();
	}
	@Override
	public E removeFirst() {
		if (theList.isEmpty()) {
			throw new java.util.NoSuchElementException("List is empty."); 
		}
		return theList.removeFirst().getData();
	}
	@Override
	public boolean contains(E data) {
		return (theList.findFirst(data)!=null);
	}
	@Override
	public int getSize() {
		return theList.getSize();
	}
	@Override
	public boolean isEmpty() {
		return theList.isEmpty();
	}
	@Override
	public java.util.Iterator<E> iterator() {
		return new ForwardListIterator();
	}
	private class ForwardListIterator implements java.util.Iterator<E> {
		SinglyLinkedList<E>.SinglyLinkedListNode next = theList.getHead();
		@Override
		public boolean hasNext() {
			return next != null;
		}
		@Override
		public E next() {
			SinglyLinkedList<E>.SinglyLinkedListNode node = next;
			try {
				next = node.getNext();
				return node.getData();
			} catch (Exception ex) {
				throw new java.util.NoSuchElementException();
			}
		}
	}
	@Override
	public String toString() {
		return theList.toString();
	}
}

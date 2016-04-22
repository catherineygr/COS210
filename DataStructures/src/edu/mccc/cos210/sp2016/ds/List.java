package edu.mccc.cos210.sp2016.ds;


public class List<E> implements IList<E> {
	@SuppressWarnings("unused")
	private final boolean DEBUG;
	protected DoublyLinkedList<E> theList;
	public List() {
		this(false);
	}
	public List(boolean debug) {
		this.theList = new DoublyLinkedList<E>(debug);
		DEBUG = debug;
	}
	@Override
	public void add(E data) {
		theList.addLast(theList.new DoublyLinkedListNode(data));
	}
	@Override
	public void addFirst(E data) {
		theList.addFirst(theList.new DoublyLinkedListNode(data));
	}
	@Override
	public void addLast(E data) {
		theList.addLast(theList.new DoublyLinkedListNode(data));
	}
	@Override
	public E getFirst() {
		return theList.getFirst().getData();
	}
	@Override
	public E getLast() {
		return theList.getLast().getData();
	}
	@Override
	public E removeFirst() {
		return theList.removeFirst().getData();
	}
	@Override
	public E removeLast() {
		return theList.removeLast().getData();
	}
	@Override
	public boolean contains(E data) {
		return theList.findFirst(data)!=null;
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
		return new ListIterator();
	}
	@Override
	public java.util.Iterator<E> reverseIterator() {
		return new ReverseListIterator();
	}
	private class ListIterator implements java.util.Iterator<E> {
		DoublyLinkedList<E>.DoublyLinkedListNode next = theList.getHead();
		DoublyLinkedList<E>.DoublyLinkedListNode node = null;
		@Override
		public boolean hasNext() {
			return next != null;
		}
		@Override
		public E next() {
			this.node = next;
			try {
				next = node.getNext();
				return node.getData();
			} catch (Exception ex) {
				throw new java.util.NoSuchElementException();
			}
		}
		@Override
		public void remove() {
			if (node==theList.getHead()) {
				theList.removeFirst();
				} else {
					//node = node.getPrev();
					node.getPrev().removeNext();}
				} 
	}
	private class ReverseListIterator implements java.util.Iterator<E> {
	DoublyLinkedList<E>.DoublyLinkedListNode prev = theList.getTail();
	@Override
	public boolean hasNext() {
		return prev != null;
	}
	@Override
	public E next() {
		DoublyLinkedList<E>.DoublyLinkedListNode node = prev;
		try {
			prev = node.getPrev();
			return node.getData();
		} catch (Exception ex) {
			throw new java.util.NoSuchElementException();
		}
	}
	@Override
	public String toString() {
		return theList.toString();
		}
	}
}

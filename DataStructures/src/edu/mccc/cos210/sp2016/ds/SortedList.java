package edu.mccc.cos210.sp2016.ds;

public class SortedList<E extends Comparable<E>> extends List<E> implements IList<E> {
	private java.util.Comparator<E> comparator;
	public SortedList() {
		this(null);
	}
	public SortedList(java.util.Comparator<E> comparator) {
		super();
		this.comparator = comparator;
	}
	@Override
	public void add(E data) {
		DoublyLinkedList<E>.DoublyLinkedListNode newNode = theList.new DoublyLinkedListNode(data);
		DoublyLinkedList<E>.DoublyLinkedListNode node = theList.getHead();
		if (node == null) {
			theList.addFirst(newNode);
			return;
		}
		while (node != null) {
			int v = 0;
			if (comparator == null) {
				v = newNode.getData().compareTo(node.getData());
			} else {
				v = comparator.compare(newNode.getData(), node.getData());
			}
			if (v < 0) {
				node.addPrev(newNode);
				return;
			}
			node = node.getNext();
		}
		theList.addLast(newNode);
	}
	@Override
	public void addFirst(E data) {
		add(data);
	}
	@Override
	public void addLast(E data) {
		add(data);
	}
}

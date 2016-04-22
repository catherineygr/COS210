package edu.mccc.cos210.sp2016.ds;

public interface IDoublyLinkedList<E> {
	public void addFirst(DoublyLinkedList<E>.DoublyLinkedListNode node);
	public void addLast(DoublyLinkedList<E>.DoublyLinkedListNode node);
	public DoublyLinkedList<E>.DoublyLinkedListNode getFirst();
	public DoublyLinkedList<E>.DoublyLinkedListNode getLast();
	public DoublyLinkedList<E>.DoublyLinkedListNode removeFirst();
	public DoublyLinkedList<E>.DoublyLinkedListNode removeLast();
	public DoublyLinkedList<E>.DoublyLinkedListNode findFirst(E data);
	public DoublyLinkedList<E>.DoublyLinkedListNode findLast(E data);
	public int getSize();
	public boolean isEmpty();
}

package edu.mccc.cos210.sp2016.ds;

public interface ISinglyLinkedList<E> {
	public void addFirst(SinglyLinkedList<E>.SinglyLinkedListNode node);
	public SinglyLinkedList<E>.SinglyLinkedListNode getFirst();
	public SinglyLinkedList<E>.SinglyLinkedListNode removeFirst();
	public SinglyLinkedList<E>.SinglyLinkedListNode findFirst(E data);
	public int getSize();
	public boolean isEmpty();
}

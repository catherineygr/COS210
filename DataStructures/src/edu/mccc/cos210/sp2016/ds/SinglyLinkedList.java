package edu.mccc.cos210.sp2016.ds;

public class SinglyLinkedList<E> implements ISinglyLinkedList<E> {
	private final boolean DEBUG;
	private SinglyLinkedListNode head = null;
	public SinglyLinkedList() {
		this(false);
	}
	public SinglyLinkedList(boolean debug) {
		DEBUG = debug;
	}
	@Override
	public void addFirst(SinglyLinkedListNode node) {
		node.setNext(head);
		setHead(node);
	}
	@Override
	public SinglyLinkedListNode getFirst() {
		if (head != null) {
			return head;
		} else {
			throw new java.util.NoSuchElementException("List is empty.");
		}
	}
	@Override
	public SinglyLinkedListNode removeFirst() {
		if (head == null) {
			throw new java.util.NoSuchElementException("List is empty.");
		} else {
			SinglyLinkedListNode temp = head;
			setHead(head.next);
			temp.setNext(null);
			return temp;
		}
	}
	@Override
	public SinglyLinkedListNode findFirst(E data) {
		for (SinglyLinkedListNode node = head; node != null; node = node.getNext()) {
			if (node.getData().equals(data)) {
				return node;
			}
		}
		return null;
	}
	SinglyLinkedListNode getHead() {
		return head;
	}
	private void setHead(SinglyLinkedListNode head) {
		this.head=head;
		
	}
	@Override
	public int getSize() {
		int size = 0;
		for (SinglyLinkedListNode node = head; node != null; node = node.getNext()) {
			size++;
		}
		return size;
	}
	@Override
	public boolean isEmpty() {
		return head == null;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SinglyLinkedListNode node = head;
		sb.append("[ ");
		if (DEBUG) {
			sb.append((head == null ? "null" : head.hashCode()) + " ");
		}
		while (node != null) {
			if (DEBUG) {
				sb.append(node.toString() + " ");
			} else {
				sb.append(node.getData().toString() + " ");
			}
			node = node.getNext();
		}
		sb.append("]");
		return sb.toString();
	}
	public class SinglyLinkedListNode {
		private SinglyLinkedListNode next = null;
		private E data;
		public SinglyLinkedListNode(E data) {
			setData(data);
		}
		public void addNext(SinglyLinkedListNode node) {
			SinglyLinkedListNode temp = next;
			setNext(node);
			node.setNext(temp);
		}
		public SinglyLinkedListNode removeNext() {
			if (next == null) {
				throw new java.util.NoSuchElementException("Element has no next.");
			}
			SinglyLinkedListNode temp = next;
			setNext(next.next);
			temp.setNext(null);
			return temp;
		}
		public SinglyLinkedListNode getNext() {
			return next;
		}
		public void setNext(SinglyLinkedListNode next) {
			this.next = next;
		}
		public E getData() {
			return data;
		}
		public void setData(E data) {
			this.data = data;
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("<" + " " + this.hashCode() + " " + (getNext() == null ? "null" : getNext().hashCode()) + " " + getData().toString() + " " + ">");
			return sb.toString();
		}
	}
}

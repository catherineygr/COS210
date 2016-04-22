package edu.mccc.cos210.sp2016.ds;

public class DoublyLinkedList<E> implements IDoublyLinkedList<E> {
	private final boolean DEBUG;
	private DoublyLinkedListNode head = null;
	private DoublyLinkedListNode tail = null;
	private int size = 0;
	public DoublyLinkedList() {
		this(false);
	}
	public DoublyLinkedList(boolean debug) {
		DEBUG = debug;
	}
	@Override
	public void addFirst(DoublyLinkedListNode node) {
		if (isEmpty()) {
			setTail(node);
			setHead(node);
			size++;
		} else {
			head.addPrev(node);
		}
	}
	@Override
	public void addLast(DoublyLinkedListNode node) {
		if (isEmpty()) {
			setHead(node);
			setTail(node);
			size++;
		} else {
			tail.addNext(node);
		}
	}
	@Override
	public DoublyLinkedListNode getFirst() {
		if (head == null) {
			throw new java.util.NoSuchElementException("List is empty.");
		}
		return head;
	}
	@Override
	public DoublyLinkedListNode getLast() {
		if (tail == null) {
			throw new java.util.NoSuchElementException("List is empty.");
		}
		return tail;
	}
	@Override
	public DoublyLinkedListNode removeFirst() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException("List is empty.");
		}
		DoublyLinkedListNode temp = head;
		if (getSize() == 1) {
			temp.setNext(null);
			temp.setPrev(null);
			setTail(null);
			setHead(null);
			size--;
			return temp;
		} else {
			setHead(temp.next);
			return head.removePrev();
		}
	}
	@Override
	public DoublyLinkedListNode removeLast() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException("List is empty.");
		}
		DoublyLinkedListNode temp = tail;
		if (getSize() == 1) {
			temp.setPrev(null);
			temp.setNext(null);
			setHead(null);
			setTail(null);
			size--;
			return temp;
		} else {
			setTail(temp.prev);
			return tail.removeNext();
		}
	}
	@Override
	public DoublyLinkedListNode findFirst(E data) {
		for (DoublyLinkedListNode node = head; node != null; node = node.getNext()) {
			if (node.getData().equals(data)) {
				return node;
			}
		}
		return null;
	}
	@Override
	public DoublyLinkedListNode findLast(E data) {
		for (DoublyLinkedListNode node = tail; node != null; node = node.getPrev()) {
			if (node.getData().equals(data)) {
				return node;
			}
		}
		return null;
	}
	@Override
	public int getSize() {
		return size;
	}
	void setSize(int i) {
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	DoublyLinkedListNode getHead() {
		return head;
	}
	void setHead(DoublyLinkedListNode head) {
		this.head = head;
	}
	DoublyLinkedListNode getTail() {
		return tail;
	}
	void setTail(DoublyLinkedListNode tail) {
		this.tail = tail;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DoublyLinkedListNode node = head;
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
		if (DEBUG) {
			sb.append((tail == null ? "null" : tail.hashCode()) + " ");
		}
		sb.append("]");
		return sb.toString();
	}
	public class DoublyLinkedListNode {
		private DoublyLinkedListNode next = null;
		private DoublyLinkedListNode prev = null;
		private E data;
		public DoublyLinkedListNode(E data) {
			setData(data);
		}
		public void addNext(DoublyLinkedListNode node) {
			if (this == tail) {
				setTail(node);
				
			} else {
				next.setPrev(node);
				node.setNext(next);
			}
			this.setNext(node);
			node.setPrev(this);
			size++;
		}
		public void addPrev(DoublyLinkedListNode node) {
			if (this == head) {
				setHead(node);	
			} else {
				prev.setNext(node);
				node.setPrev(prev);
			}
			this.setPrev(node);
			node.setNext(this);
			size++;
		}
		public DoublyLinkedListNode removeNext() {
			if (next == null) {
				throw new java.util.NoSuchElementException("Node has no next.");
			}
			DoublyLinkedListNode temp = next;
			if (temp.next == null) {
				setTail(this);
				setNext(null);
			}else {
				setNext(temp.next);
				next.setPrev(this);
			}
			temp.setNext(null);
			temp.setPrev(null);
			size--;
			return temp;
		}
		public DoublyLinkedListNode removePrev() {
			if (prev == null) {
				throw new java.util.NoSuchElementException("Node has no previous.");
			}
			
			DoublyLinkedListNode temp = prev;
			if (temp.prev == null) {
				setHead(this);
				setPrev(null);
			} else {
				setPrev(temp.prev);
				prev.setNext(this);
			}
			temp.setPrev(null);
			temp.setNext(null);
			size--;
			return temp;
		}
		public DoublyLinkedListNode getNext() {
			return next;
		}
		public DoublyLinkedListNode getPrev() {
			return prev;
		}
		public void setNext(DoublyLinkedListNode next) {
			this.next = next;
		}
		public void setPrev(DoublyLinkedListNode prev) {
			this.prev = prev;
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
			sb.append("<" + " " + this.hashCode() + " " + (getNext() == null ? "null" : getNext().hashCode()) + " " + (getPrev() == null ? "null" : getPrev().hashCode()) + " " + getData().toString() + " " + ">");
			return sb.toString();
		}
	}
}

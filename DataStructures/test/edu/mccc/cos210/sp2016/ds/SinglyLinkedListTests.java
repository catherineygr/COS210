package edu.mccc.cos210.sp2016.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class SinglyLinkedListTests {
	@Test
	public void newListIsEmpty() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		assertTrue(theList.isEmpty());
		assertEquals(0, theList.getSize());
		assertEquals(null, theList.getHead());
	}
	@Test
	public void addElementListNotEmpty() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		SinglyLinkedList<String>.SinglyLinkedListNode node = theList.new SinglyLinkedListNode("Fish");
		theList.addFirst(node);
		assertFalse(theList.isEmpty());
		assertEquals(node, theList.getFirst());
		assertEquals(1, theList.getSize());
		assertNull(theList.getFirst().getNext());
	}
	@Test
	public void addElementHasCorrectData() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		assertEquals("Fish", theList.getFirst().getData());
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void getFirstNoElement() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.getFirst();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void removeFirstNoElement() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.removeFirst();
	}
	@Test
	public void addAndRemoveListIsEmpty() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		SinglyLinkedList<String>.SinglyLinkedListNode node = theList.new SinglyLinkedListNode("Fish");
		theList.addFirst(node);
		theList.removeFirst();
		assertTrue(theList.isEmpty());
		assertEquals(null, theList.getHead());
		assertEquals(0, theList.getSize());
		assertEquals(null, node.getNext());
	}
	@Test
	public void removeFirstDeletesCorrectElement() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		theList.addFirst(theList.new SinglyLinkedListNode("Sheep"));
		assertEquals("Sheep", theList.removeFirst().getData());
		assertEquals(1, theList.getSize());
	}
	@Test
	public void addMultipleElementsSizeCorrect() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		theList.addFirst(theList.new SinglyLinkedListNode("Sheep"));
		theList.addFirst(theList.new SinglyLinkedListNode("Duck"));
		assertTrue(theList.getSize() == 3);
	}
	@Test
	public void findFirstWhenLast() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		theList.addFirst(theList.new SinglyLinkedListNode("Sheep"));
		theList.addFirst(theList.new SinglyLinkedListNode("Duck"));
		SinglyLinkedList<String>.SinglyLinkedListNode node = theList.findFirst("Fish");
		assertEquals("Fish", node.getData());
	}
	@Test
	public void findFirstWhenFirst() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		theList.addFirst(theList.new SinglyLinkedListNode("Sheep"));
		theList.addFirst(theList.new SinglyLinkedListNode("Duck"));
		SinglyLinkedList<String>.SinglyLinkedListNode node = theList.findFirst("Duck");
		assertEquals("Duck", node.getData());
	}
	@Test
	public void findFirstWhenMiddle() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		theList.addFirst(theList.new SinglyLinkedListNode("Sheep"));
		theList.addFirst(theList.new SinglyLinkedListNode("Duck"));
		SinglyLinkedList<String>.SinglyLinkedListNode node = theList.findFirst("Sheep");
		assertEquals("Sheep", node.getData());
	}
	@Test
	public void addToLastPositionCorrect() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		theList.addFirst(theList.new SinglyLinkedListNode("Sheep"));
		theList.addFirst(theList.new SinglyLinkedListNode("Duck"));
		SinglyLinkedList<String>.SinglyLinkedListNode node = theList.findFirst("Fish");
		SinglyLinkedList<String>.SinglyLinkedListNode newNode = theList.new SinglyLinkedListNode("Horse");
		node.addNext(newNode);
		assertTrue(theList.getSize() == 4);
		assertEquals(newNode, node.getNext());
		assertEquals(null, newNode.getNext());
	}
	@Test
	public void addToFirstPositionCorrect() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		theList.addFirst(theList.new SinglyLinkedListNode("Sheep"));
		theList.addFirst(theList.new SinglyLinkedListNode("Duck"));
		SinglyLinkedList<String>.SinglyLinkedListNode node = theList.findFirst("Duck");
		SinglyLinkedList<String>.SinglyLinkedListNode newNode = theList.new SinglyLinkedListNode("Horse");
		node.addNext(newNode);
		assertTrue(theList.getSize() == 4);
		assertEquals(newNode, node.getNext());
		assertEquals("Sheep", newNode.getNext().getData());
	}
	@Test
	public void addToMiddlePositionCorrect() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		theList.addFirst(theList.new SinglyLinkedListNode("Sheep"));
		theList.addFirst(theList.new SinglyLinkedListNode("Duck"));
		SinglyLinkedList<String>.SinglyLinkedListNode node = theList.findFirst("Sheep");
		SinglyLinkedList<String>.SinglyLinkedListNode newNode = theList.new SinglyLinkedListNode("Horse");
		node.addNext(newNode);
		assertTrue(theList.getSize() == 4);
		assertEquals(newNode, node.getNext());
		assertEquals("Fish", newNode.getNext().getData());
	}
	@Test
	public void removeNextFromFirstPositionCorrect() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		theList.addFirst(theList.new SinglyLinkedListNode("Sheep"));
		theList.addFirst(theList.new SinglyLinkedListNode("Duck"));
		theList.addFirst(theList.new SinglyLinkedListNode("Cow"));
		SinglyLinkedList<String>.SinglyLinkedListNode node = theList.findFirst("Cow");
		SinglyLinkedList<String>.SinglyLinkedListNode removedNode = node.removeNext();
		assertTrue(theList.getSize() == 3);
		assertEquals("Duck", removedNode.getData());
		assertEquals(null, removedNode.getNext());
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void removeNextFromLastPositionCorrect() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		theList.addFirst(theList.new SinglyLinkedListNode("Sheep"));
		theList.addFirst(theList.new SinglyLinkedListNode("Duck"));
		theList.addFirst(theList.new SinglyLinkedListNode("Cow"));
		SinglyLinkedList<String>.SinglyLinkedListNode node = theList.findFirst("Fish");
		node.removeNext();
	}
	@Test
	public void removeNextFromMiddlePositionCorrect() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		theList.addFirst(theList.new SinglyLinkedListNode("Sheep"));
		theList.addFirst(theList.new SinglyLinkedListNode("Duck"));
		theList.addFirst(theList.new SinglyLinkedListNode("Cow"));
		SinglyLinkedList<String>.SinglyLinkedListNode node = theList.findFirst("Sheep");
		SinglyLinkedList<String>.SinglyLinkedListNode removedNode = node.removeNext();
		assertTrue(theList.getSize() == 3);
		assertEquals("Fish", removedNode.getData());
		assertEquals(null, removedNode.getNext());
	}
	@Test
	public void validateRemovedNodePointers() {
		SinglyLinkedList<String> theList = new SinglyLinkedList<>();
		theList.addFirst(theList.new SinglyLinkedListNode("Fish"));
		theList.addFirst(theList.new SinglyLinkedListNode("Sheep"));
		SinglyLinkedList<String>.SinglyLinkedListNode node = theList.removeFirst();
		assertEquals(null, node.getNext());		
	}
}

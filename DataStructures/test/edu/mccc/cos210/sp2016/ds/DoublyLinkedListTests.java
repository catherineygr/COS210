package edu.mccc.cos210.sp2016.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DoublyLinkedListTests {
	@Test
	public void newListIsEmpty() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		assertTrue(theList.isEmpty());
		assertEquals(0, theList.getSize());
		assertEquals(null, theList.getHead());
	}
	@Test
	public void addFirstElementListNotEmpty() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.new DoublyLinkedListNode("Fish");
		theList.addFirst(node);
		assertFalse(theList.isEmpty());
		assertEquals(node, theList.getFirst());
		assertEquals(node, theList.getLast());
		assertEquals(1, theList.getSize());
		assertNull(theList.getFirst().getNext());
	}
	@Test
	public void addLastElementListNotEmpty() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.new DoublyLinkedListNode("Fish");
		theList.addLast(node);
		assertFalse(theList.isEmpty());
		assertEquals(node, theList.getFirst());
		assertEquals(node, theList.getLast());
		assertEquals(1, theList.getSize());
		assertNull(theList.getFirst().getNext());
	}
	@Test
	public void addFirstElementHasCorrectData() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		assertEquals("Fish", theList.getFirst().getData());
		assertEquals("Fish", theList.getLast().getData());
	}
	@Test
	public void addLastElementHasCorrectData() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addLast(theList.new DoublyLinkedListNode("Fish"));
		assertEquals("Fish", theList.getFirst().getData());
		assertEquals("Fish", theList.getLast().getData());
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void getFirstNoElement() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.getFirst();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void getLastNoElement() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.getLast();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void removeFirstNoElement() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.removeFirst();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void removeLastNoElement() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.removeLast();
	}
	@Test
	public void addFirstRemoveFirstListIsEmpty() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.new DoublyLinkedListNode("Fish");
		theList.addFirst(node);
		theList.removeFirst();
		assertTrue(theList.isEmpty());
		assertEquals(null, theList.getHead());
		assertEquals(0, theList.getSize());
		assertEquals(null, node.getNext());
	}
	@Test
	public void addFirstRemoveLastListIsEmpty() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.new DoublyLinkedListNode("Fish");
		theList.addFirst(node);
		theList.removeLast();
		assertTrue(theList.isEmpty());
		assertEquals(null, theList.getHead());
		assertEquals(0, theList.getSize());
		assertEquals(null, node.getNext());
	}
	@Test
	public void addLastRemoveFirstListIsEmpty() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.new DoublyLinkedListNode("Fish");
		theList.addLast(node);
		theList.removeFirst();
		assertTrue(theList.isEmpty());
		assertEquals(null, theList.getHead());
		assertEquals(0, theList.getSize());
		assertEquals(null, node.getNext());
	}
	@Test
	public void addLastRemoveLastListIsEmpty() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.new DoublyLinkedListNode("Fish");
		theList.addLast(node);
		theList.removeLast();
		assertTrue(theList.isEmpty());
		assertEquals(null, theList.getHead());
		assertEquals(0, theList.getSize());
		assertEquals(null, node.getNext());
	}
	@Test
	public void removeFirstDeletesCorrectElement() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		assertEquals("Sheep", theList.removeFirst().getData());
		assertEquals(1, theList.getSize());
	}
	@Test
	public void removeLastDeletesCorrectElement() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addLast(theList.new DoublyLinkedListNode("Fish"));
		theList.addLast(theList.new DoublyLinkedListNode("Sheep"));
		assertEquals("Sheep", theList.removeLast().getData());
		assertEquals(1, theList.getSize());
	}
	@Test
	public void addFirstMultipleElementsSizeCorrect() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		assertTrue(theList.getSize() == 3);
	}
	@Test
	public void addLastMultipleElementsSizeCorrect() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addLast(theList.new DoublyLinkedListNode("Fish"));
		theList.addLast(theList.new DoublyLinkedListNode("Sheep"));
		theList.addLast(theList.new DoublyLinkedListNode("Duck"));
		assertTrue(theList.getSize() == 3);
	}
	@Test
	public void addMixedMultipleElementsSizeCorrect() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addLast(theList.new DoublyLinkedListNode("Sheep"));
		theList.addLast(theList.new DoublyLinkedListNode("Cat"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		assertTrue(theList.getSize() == 4);
	}
	@Test
	public void findFirstWhenLast() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new  DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Fish");
		assertEquals("Fish", node.getData());
	}
	@Test
	public void findFirstWhenFirst() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Duck");
		assertEquals("Duck", node.getData());
	}
	@Test
	public void findFirstWhenMiddle() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Sheep");
		assertEquals("Sheep", node.getData());
	}
	@Test
	public void addToLastPositionCorrect() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Fish");
		DoublyLinkedList<String>.DoublyLinkedListNode newNode = theList.new DoublyLinkedListNode("Horse");
		node.addNext(newNode);
		assertTrue(theList.getSize() == 4);
		assertEquals(newNode, node.getNext());
		assertEquals(null, newNode.getNext());
	}
	@Test
	public void addToFirstPositionCorrect() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Duck");
		DoublyLinkedList<String>.DoublyLinkedListNode newNode = theList.new DoublyLinkedListNode("Horse");
		node.addNext(newNode);
		assertTrue(theList.getSize() == 4);
		assertEquals(newNode, node.getNext());
		assertEquals("Sheep", newNode.getNext().getData());
	}
	@Test
	public void addToMiddlePositionCorrect() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Sheep");
		DoublyLinkedList<String>.DoublyLinkedListNode newNode = theList.new DoublyLinkedListNode("Horse");
		node.addNext(newNode);
		assertTrue(theList.getSize() == 4);
		assertEquals(newNode, node.getNext());
		assertEquals("Fish", newNode.getNext().getData());
	}
	@Test
	public void removeNextFromFirstPositionCorrect() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Frog"));
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		theList.addFirst(theList.new DoublyLinkedListNode("Cow"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Cow");
		DoublyLinkedList<String>.DoublyLinkedListNode removedNode = node.removeNext();
		assertTrue(theList.getSize() == 4);
		assertEquals("Duck", removedNode.getData());
		assertEquals(null, removedNode.getNext());
		assertEquals(null, removedNode.getPrev());
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void removeNextFromLastPositionCorrect() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Frog"));
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		theList.addFirst(theList.new DoublyLinkedListNode("Cow"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Frog");
		node.removeNext();
	}
	@Test
	public void removeNextFromMiddlePositionCorrect() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Frog"));
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		theList.addFirst(theList.new DoublyLinkedListNode("Cow"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Sheep");
		DoublyLinkedList<String>.DoublyLinkedListNode removedNode = node.removeNext();
		assertTrue(theList.getSize() == 4);
		assertEquals("Fish", removedNode.getData());
		assertEquals(null, removedNode.getNext());
		assertEquals(null, removedNode.getPrev());
	}
	@Test
	public void removeNextFromMiddlePositionCorrectAtEnd() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Frog"));
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		theList.addFirst(theList.new DoublyLinkedListNode("Cow"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Fish");
		DoublyLinkedList<String>.DoublyLinkedListNode removedNode = node.removeNext();
		assertTrue(theList.getSize() == 4);
		assertEquals("Frog", removedNode.getData());
		assertEquals(null, removedNode.getNext());
		assertEquals(null, removedNode.getPrev());
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void removePrevFromFirstPositionCorrect() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Frog"));
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		theList.addFirst(theList.new DoublyLinkedListNode("Cow"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Cow");
		node.removePrev();
	}	
	@Test
	public void removePrevFromLastPositionCorrect() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Frog"));
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		theList.addFirst(theList.new DoublyLinkedListNode("Cow"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Frog");
		DoublyLinkedList<String>.DoublyLinkedListNode removedNode = node.removePrev();
		assertTrue(theList.getSize() == 4);
		assertEquals("Fish", removedNode.getData());
		assertEquals(null, removedNode.getNext());
		assertEquals(null, removedNode.getPrev());
	}
	@Test
	public void removePrevFromMiddlePositionCorrect() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Frog"));
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		theList.addFirst(theList.new DoublyLinkedListNode("Cow"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Sheep");
		DoublyLinkedList<String>.DoublyLinkedListNode removedNode = node.removePrev();
		assertTrue(theList.getSize() == 4);
		assertEquals("Duck", removedNode.getData());
		assertEquals(null, removedNode.getNext());
		assertEquals(null, removedNode.getPrev());
	}
	@Test
	public void removePrevFromMiddlePositionCorrectAtEnd() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Frog"));
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		theList.addFirst(theList.new DoublyLinkedListNode("Cow"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.findFirst("Duck");
		DoublyLinkedList<String>.DoublyLinkedListNode removedNode = node.removePrev();
		assertTrue(theList.getSize() == 4);
		assertEquals("Cow", removedNode.getData());
		assertEquals(null, removedNode.getNext());
		assertEquals(null, removedNode.getPrev());
	}
	@Test
	public void validateRemovedNodePointers() {
		DoublyLinkedList<String> theList = new DoublyLinkedList<>();
		theList.addFirst(theList.new DoublyLinkedListNode("Fish"));
		theList.addFirst(theList.new DoublyLinkedListNode("Sheep"));
		theList.addFirst(theList.new DoublyLinkedListNode("Duck"));
		DoublyLinkedList<String>.DoublyLinkedListNode node = theList.removeFirst();
		assertEquals(null, node.getNext());		
		assertEquals(null, node.getPrev());		
		node = theList.removeLast();
		assertEquals(null, node.getNext());		
		assertEquals(null, node.getPrev());		
	}
}

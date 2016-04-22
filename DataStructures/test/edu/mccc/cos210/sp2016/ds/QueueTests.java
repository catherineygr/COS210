package edu.mccc.cos210.sp2016.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTests {
	@Test
	public void newQueueIsEmpty() {
		IQueue<String> theQueue = new Queue<>();
		assertTrue(theQueue.isEmpty());
	}
	@Test
	public void enqueueElementIsNotEmpty() {
		IQueue<String> theQueue = new Queue<>();
		theQueue.enqueue("Duck");
		assertFalse(theQueue.isEmpty());
	}
	@Test
	public void peekElementSucceeds() {
		IQueue<String> theQueue = new Queue<>();
		theQueue.enqueue("Duck");
		theQueue.enqueue("Sheep");
		assertEquals("Duck", theQueue.peek());
	}
	@Test
	public void dequeueElementSucceeds() {
		IQueue<String> theQueue = new Queue<>();
		theQueue.enqueue("Duck");
		assertFalse(theQueue.isEmpty());
		theQueue.dequeue();
		assertTrue(theQueue.isEmpty());
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void peekElementFails() {
		IQueue<String> theQueue = new Queue<>();
		theQueue.peek();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void dequeueElementFails() {
		IQueue<String> theQueue = new Queue<>();
		theQueue.dequeue();
	}
	@Test
	public void queueWorksCorrectly() {
		IQueue<String> theQueue = new Queue<>();
		theQueue.enqueue("Duck");
		theQueue.enqueue("Sheep");
		theQueue.enqueue("Cat");
		assertEquals("Duck", theQueue.peek());
		theQueue.dequeue();
		assertEquals("Sheep", theQueue.dequeue());
		assertEquals("Cat", theQueue.peek());
		assertEquals("Cat", theQueue.dequeue());
		assertTrue(theQueue.isEmpty());
	}
}

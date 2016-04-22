package edu.mccc.cos210.sp2016.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class DequeTests {
	@Test
	public void newDequeIsEmpty() {
		IDeque<String> theDeque = new Deque<>();
		assertTrue(theDeque.isEmpty());
	}
	@Test
	public void enqueueElementIsNotEmpty() {
		IDeque<String> theDeque = new Deque<>();
		theDeque.enqueueFirst("Duck");
		assertFalse(theDeque.isEmpty());
	}
	@Test
	public void peekElementSucceeds() {
		IDeque<String> theDeque = new Deque<>();
		theDeque.enqueueFirst("Duck");
		theDeque.enqueueFirst("Sheep");
		assertEquals("Sheep", theDeque.peekFirst());
	}
	@Test
	public void dequeueElementSucceeds() {
		IDeque<String> theDeque = new Deque<>();
		theDeque.enqueueFirst("Duck");
		assertFalse(theDeque.isEmpty());
		theDeque.dequeueFirst();
		assertTrue(theDeque.isEmpty());
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void peekElementFails() {
		IDeque<String> theDeque = new Deque<>();
		theDeque.peekFirst();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void dequeueElementFails() {
		IDeque<String> theDeque = new Deque<>();
		theDeque.dequeueFirst();
	}
	@Test
	public void dequeWorksCorrectly() {
		IDeque<String> theDeque = new Deque<>();
		theDeque.enqueueFirst("Duck");
		theDeque.enqueueFirst("Sheep");
		theDeque.enqueueFirst("Cat");
		assertEquals("Cat", theDeque.peekFirst());
		theDeque.dequeueFirst();
		assertEquals("Sheep", theDeque.dequeueFirst());
		assertEquals("Duck", theDeque.peekFirst());
		assertEquals("Duck", theDeque.dequeueFirst());
		assertTrue(theDeque.isEmpty());
	}
}

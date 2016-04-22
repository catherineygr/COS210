package edu.mccc.cos210.sp2016.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTests {
	@Test
	public void newStackIsEmpty() {
		IStack<String> theStack = new Stack<>();
		assertTrue(theStack.isEmpty());
	}
	@Test
	public void pushElementIsNotEmpty() {
		IStack<String> theStack = new Stack<>();
		theStack.push("Duck");
		assertFalse(theStack.isEmpty());
	}
	@Test
	public void peekElementSucceeds() {
		IStack<String> theStack = new Stack<>();
		theStack.push("Duck");
		assertEquals("Duck", theStack.peek());
	}
	@Test
	public void popElementSucceeds() {
		IStack<String> theStack = new Stack<>();
		theStack.push("Duck");
		assertFalse(theStack.isEmpty());
		theStack.pop();
		assertTrue(theStack.isEmpty());
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void peekElementFails() {
		IStack<String> theStack = new Stack<>();
		theStack.peek();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void popElementFails() {
		IStack<String> theStack = new Stack<>();
		theStack.pop();
	}
	@Test
	public void stackWorksCorrectly() {
		IStack<String> theStack = new Stack<>();
		theStack.push("Duck");
		theStack.push("Sheep");
		theStack.push("Cat");
		assertEquals("Cat", theStack.peek());
		theStack.pop();
		assertEquals("Sheep", theStack.peek());
		theStack.pop();
		assertEquals("Duck", theStack.peek());
		theStack.pop();
		assertTrue(theStack.isEmpty());
	}
}

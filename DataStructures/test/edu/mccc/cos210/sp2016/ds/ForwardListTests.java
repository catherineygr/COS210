package edu.mccc.cos210.sp2016.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ForwardListTests {
	@Test
	public void newListIsEmpty() {
		IForwardList<String> theList = new ForwardList<>();
		assertTrue(theList.isEmpty());
		assertEquals(0, theList.getSize());
	}
	@Test
	public void addElementListNotEmpty() {
		IForwardList<String> theList = new ForwardList<>();
		theList.addFirst("Horse");
		assertFalse(theList.isEmpty());
		assertTrue(theList.getSize() == 1);
	}
	@Test
	public void addElementHasCorrectData() {
		IForwardList<String> theList = new ForwardList<>();
		theList.addFirst("Horse");
		assertEquals("Horse", theList.getFirst());
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void getFirstNoElement() {
		IForwardList<String> theList = new ForwardList<>();
		theList.getFirst();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void removeFirstNoElement() {
		IForwardList<String> theList = new ForwardList<>();
		theList.removeFirst();
	}
	@Test
	public void addAndRemoveListIsEmpty() {
		IForwardList<String> theList = new ForwardList<>();
		theList.addFirst("Fish");
		theList.removeFirst();
		assertTrue(theList.isEmpty());
		assertEquals(0, theList.getSize());
	}
	@Test
	public void removeFirstDeletesCorrectElement() {
		IForwardList<String> theList = new ForwardList<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		assertEquals("Sheep", theList.removeFirst());
		assertEquals(1, theList.getSize());
	}
	@Test
	public void addMultipleElementsSizeCorrect() {
		IForwardList<String> theList = new ForwardList<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		theList.addFirst("Duck");
		assertTrue(theList.getSize() == 3);
	}
	@Test
	public void containsString() {
		IForwardList<String> theList = new ForwardList<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		theList.addFirst("Duck");
		assertTrue(theList.contains("Sheep"));
		assertTrue(theList.contains("Duck"));
		assertFalse(theList.contains("Horse"));
		assertTrue(theList.contains("Fish"));
		theList.removeFirst();
		theList.addFirst("Horse");
		assertTrue(theList.contains("Horse"));
		assertFalse(theList.contains("Duck"));
	}
	@Test
	public void iterateFull() {
		IForwardList<String> theList = new ForwardList<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		theList.addFirst("Duck");
		theList.addFirst("Horse");
		StringBuilder sb = new StringBuilder();
		for (String s : theList) {
			sb.append(s);
		}
		assertEquals("HorseDuckSheepFish", sb.toString());
	}
	@Test
	public void iterateEmpty() {
		IForwardList<String> theList = new ForwardList<>();
		StringBuilder sb = new StringBuilder();
		for (String s : theList) {
			sb.append(s);
		}
		assertEquals("", sb.toString());
	}
}

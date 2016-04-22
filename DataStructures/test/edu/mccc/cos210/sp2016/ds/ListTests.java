package edu.mccc.cos210.sp2016.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ListTests {
	@Test
	public void newListIsEmpty() {
		IList<String> theList = new List<>();
		assertTrue(theList.isEmpty());
		assertEquals(0, theList.getSize());
	}
	@Test
	public void addFirstElementListNotEmpty() {
		IList<String> theList = new List<>();
		theList.addFirst("Horse");
		assertFalse(theList.isEmpty());
		assertTrue(theList.getSize() == 1);
	}
	@Test
	public void addLastElementListNotEmpty() {
		IList<String> theList = new List<>();
		theList.addLast("Horse");
		assertFalse(theList.isEmpty());
		assertTrue(theList.getSize() == 1);
	}
	@Test
	public void addFirstElementHasCorrectData() {
		IList<String> theList = new List<>();
		theList.addFirst("Horse");
		assertEquals("Horse", theList.getFirst());
	}
	@Test
	public void addLastElementHasCorrectData() {
		IList<String> theList = new List<>();
		theList.addLast("Horse");
		assertEquals("Horse", theList.getLast());
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void getFirstNoElement() {
		IList<String> theList = new List<>();
		theList.getFirst();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void getLastNoElement() {
		IList<String> theList = new List<>();
		theList.getLast();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void removeFirstNoElement() {
		IList<String> theList = new List<>();
		theList.removeFirst();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void removeLastNoElement() {
		IList<String> theList = new List<>();
		theList.removeLast();
	}
	@Test
	public void addFirstAndRemoveListIsEmpty() {
		IList<String> theList = new List<>();
		theList.addFirst("Fish");
		theList.removeFirst();
		assertTrue(theList.isEmpty());
		assertEquals(0, theList.getSize());
	}
	@Test
	public void addLastAndRemoveListIsEmpty() {
		IList<String> theList = new List<>();
		theList.addLast("Fish");
		theList.removeLast();
		assertTrue(theList.isEmpty());
		assertEquals(0, theList.getSize());
	}
	@Test
	public void removeFirstDeletesCorrectElement() {
		IList<String> theList = new List<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		assertEquals("Sheep", theList.removeFirst());
		assertEquals(1, theList.getSize());
	}
	@Test
	public void removeLastDeletesCorrectElement() {
		IList<String> theList = new List<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		assertEquals("Fish", theList.removeLast());
		assertEquals(1, theList.getSize());
	}
	@Test
	public void addFirstMultipleElementsSizeCorrect() {
		IList<String> theList = new List<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		theList.addFirst("Duck");
		assertTrue(theList.getSize() == 3);
	}
	@Test
	public void addLastMultipleElementsSizeCorrect() {
		IList<String> theList = new List<>();
		theList.addLast("Fish");
		theList.addLast("Sheep");
		theList.addLast("Duck");
		assertTrue(theList.getSize() == 3);
	}
	@Test
	public void addMultipleElementsSizeCorrect() {
		IList<String> theList = new List<>();
		theList.addLast("Fish");
		theList.addFirst("Sheep");
		theList.addLast("Duck");
		assertTrue(theList.getSize() == 3);
	}
	@Test
	public void containsString() {
		IList<String> theList = new List<>();
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
		IList<String> theList = new List<>();
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
		IList<String> theList = new List<>();
		StringBuilder sb = new StringBuilder();
		for (String s : theList) {
			sb.append(s);
		}
		assertEquals("", sb.toString());
	}
	@Test
	public void reverseIterateFull() {
		IList<String> theList = new List<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		theList.addFirst("Duck");
		theList.addFirst("Horse");
		StringBuilder sb = new StringBuilder();
		java.util.Iterator<String> rit = theList.reverseIterator();
		while (rit.hasNext()) {
			sb.append(rit.next());
		}
		assertEquals("FishSheepDuckHorse", sb.toString());
	}
	@Test
	public void reverseIterateEmpty() {
		IList<String> theList = new List<>();
		StringBuilder sb = new StringBuilder();
		java.util.Iterator<String> rit = theList.reverseIterator();
		while (rit.hasNext()) {
			sb.append(rit.next());
		}
		assertEquals("", sb.toString());
	}
	@Test
	public void addWorks() {
		IList<String> theList = new List<>();
		theList.add("Fish");
		theList.add("Sheep");
		theList.add("Duck");
		theList.add("Horse");
		StringBuilder sb = new StringBuilder();
		for (String s : theList) {
			sb.append(s);
		}
		assertEquals("FishSheepDuckHorse", sb.toString());
	}
	@Test
	public void removeFromEmptyListViaIterator() {
		IList<String> theList = new List<>();
		java.util.Iterator<String> it = theList.iterator();
		while (it.hasNext()) {
			if (it.next().equals("Fish")) {
				it.remove();
			}
		}
		assertFalse(theList.contains("Fish"));
		assertEquals(0, theList.getSize());
	}
	@Test
	public void removeOnlyItemFromListViaIterator() {
		IList<String> theList = new List<>();
		theList.add("Fish");
		java.util.Iterator<String> it = theList.iterator();
		while (it.hasNext()) {
			if (it.next().equals("Fish")) {
				it.remove();
			}
		}
		assertFalse(theList.contains("Fish"));
		assertEquals(0, theList.getSize());
	}
	@Test
	public void removeFirstItemFromListViaIterator() {
		IList<String> theList = new List<>();
		theList.add("Fish");
		theList.add("Kangaroo");
		java.util.Iterator<String> it = theList.iterator();
		while (it.hasNext()) {
			if (it.next().equals("Fish")) {
				it.remove();
			}
		}
		assertFalse(theList.contains("Fish"));
		assertEquals(1, theList.getSize());
	}
	@Test
	public void removeLastItemFromListViaIterator() {
		IList<String> theList = new List<>();
		theList.add("Fish");
		theList.add("Kangaroo");
		java.util.Iterator<String> it = theList.iterator();
		while (it.hasNext()) {
			if (it.next().equals("Kangaroo")) {
				it.remove();
			}
		}
		assertFalse(theList.contains("Kangaroo"));
		assertEquals(1, theList.getSize());
	}
	@Test
	public void removeMiddleItemFromListViaIterator() {
		IList<String> theList = new List<>();
		theList.add("Fish");
		theList.add("Crow");
		theList.add("Kangaroo");
		java.util.Iterator<String> it = theList.iterator();
		while (it.hasNext()) {
			if (it.next().equals("Crow")) {
				it.remove();
			}
		}
		assertFalse(theList.contains("Crow"));
		assertEquals(2, theList.getSize());
	}
}
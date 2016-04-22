package edu.mccc.cos210.sp2016.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SortedListTests {
	@Test
	public void addOneItem() {
		IList<String> theList = new SortedList<>();
		theList.add("Duck");
		assertEquals("Duck", theList.getFirst());
	}
	@Test
	public void addTwoItemsAZ() {
		IList<String> theList = new SortedList<>();
		theList.add("Duck");
		theList.add("Fish");
		assertEquals("Duck", theList.removeFirst());
		assertEquals("Fish", theList.removeFirst());
	}
	@Test
	public void addTwoItemsZA() {
		IList<String> theList = new SortedList<>();
		theList.add("Fish");
		theList.add("Duck");
		assertEquals("Duck", theList.removeFirst());
		assertEquals("Fish", theList.removeFirst());
	}
	@Test
	public void addItemsMixed() {
		IList<String> theList = new SortedList<>();
		theList.add("Fish");
		theList.add("Sheep");
		theList.add("Dog");
		theList.add("Horse");
		theList.add("Cat");
		theList.add("Duck");
		StringBuilder sb = new StringBuilder();
		for (String s : theList) {
			sb.append(s);
		}
		assertEquals("CatDogDuckFishHorseSheep", sb.toString());
	}
	@Test
	public void addItemsMixedWidthDups() {
		IList<String> theList = new SortedList<>();
		theList.add("Fish");
		theList.add("Fish");
		theList.add("Cat");
		theList.add("Duck");
		theList.add("Sheep");
		theList.add("Dog");
		theList.add("Horse");
		theList.add("Cat");
		theList.add("Duck");
		StringBuilder sb = new StringBuilder();
		for (String s : theList) {
			sb.append(s);
		}
		assertEquals("CatCatDogDuckDuckFishFishHorseSheep", sb.toString());
	}
	@Test
	public void newListIsEmpty() {
		IList<String> theList = new SortedList<>();
		assertTrue(theList.isEmpty());
		assertEquals(0, theList.getSize());
	}
	@Test
	public void addFirstElementListNotEmpty() {
		IList<String> theList = new SortedList<>();
		theList.addFirst("Horse");
		assertFalse(theList.isEmpty());
		assertTrue(theList.getSize() == 1);
	}
	@Test
	public void addLastElementListNotEmpty() {
		IList<String> theList = new SortedList<>();
		theList.addLast("Horse");
		assertFalse(theList.isEmpty());
		assertTrue(theList.getSize() == 1);
	}
	@Test
	public void addFirstElementHasCorrectData() {
		IList<String> theList = new SortedList<>();
		theList.addFirst("Horse");
		assertEquals("Horse", theList.getFirst());
	}
	@Test
	public void addLastElementHasCorrectData() {
		IList<String> theList = new SortedList<>();
		theList.addLast("Horse");
		assertEquals("Horse", theList.getLast());
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void getFirstNoElement() {
		IList<String> theList = new SortedList<>();
		theList.getFirst();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void getLastNoElement() {
		IList<String> theList = new SortedList<>();
		theList.getLast();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void removeFirstNoElement() {
		IList<String> theList = new SortedList<>();
		theList.removeFirst();
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void removeLastNoElement() {
		IList<String> theList = new SortedList<>();
		theList.removeLast();
	}
	@Test
	public void addFirstAndRemoveListIsEmpty() {
		IList<String> theList = new SortedList<>();
		theList.addFirst("Fish");
		theList.removeFirst();
		assertTrue(theList.isEmpty());
		assertEquals(0, theList.getSize());
	}
	@Test
	public void addLastAndRemoveListIsEmpty() {
		IList<String> theList = new SortedList<>();
		theList.addLast("Fish");
		theList.removeLast();
		assertTrue(theList.isEmpty());
		assertEquals(0, theList.getSize());
	}
	@Test
	public void removeFirstDeletesCorrectElement() {
		IList<String> theList = new SortedList<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		assertEquals("Fish", theList.removeFirst());
		assertEquals(1, theList.getSize());
	}
	@Test
	public void removeLastDeletesCorrectElement() {
		IList<String> theList = new SortedList<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		assertEquals("Sheep", theList.removeLast());
		assertEquals(1, theList.getSize());
	}
	@Test
	public void addFirstMultipleElementsSizeCorrect() {
		IList<String> theList = new SortedList<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		theList.addFirst("Duck");
		assertTrue(theList.getSize() == 3);
	}
	@Test
	public void addLastMultipleElementsSizeCorrect() {
		IList<String> theList = new SortedList<>();
		theList.addLast("Fish");
		theList.addLast("Sheep");
		theList.addLast("Duck");
		assertTrue(theList.getSize() == 3);
	}
	@Test
	public void addMultipleElementsSizeCorrect() {
		IList<String> theList = new SortedList<>();
		theList.addLast("Fish");
		theList.addFirst("Sheep");
		theList.addLast("Duck");
		assertTrue(theList.getSize() == 3);
	}
	@Test
	public void containsString() {
		IList<String> theList = new SortedList<>();
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
		IList<String> theList = new SortedList<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		theList.addFirst("Duck");
		theList.addFirst("Horse");
		StringBuilder sb = new StringBuilder();
		for (String s : theList) {
			sb.append(s);
		}
		assertEquals("DuckFishHorseSheep", sb.toString());
	}
	@Test
	public void iterateEmpty() {
		IList<String> theList = new SortedList<>();
		StringBuilder sb = new StringBuilder();
		for (String s : theList) {
			sb.append(s);
		}
		assertEquals("", sb.toString());
	}
	@Test
	public void reverseIterateFull() {
		IList<String> theList = new SortedList<>();
		theList.addFirst("Fish");
		theList.addFirst("Sheep");
		theList.addFirst("Duck");
		theList.addFirst("Horse");
		StringBuilder sb = new StringBuilder();
		java.util.Iterator<String> rit = theList.reverseIterator();
		while (rit.hasNext()) {
			sb.append(rit.next());
		}
		assertEquals("SheepHorseFishDuck", sb.toString());
	}
	@Test
	public void reverseIterateEmpty() {
		IList<String> theList = new SortedList<>();
		StringBuilder sb = new StringBuilder();
		java.util.Iterator<String> rit = theList.reverseIterator();
		while (rit.hasNext()) {
			sb.append(rit.next());
		}
		assertEquals("", sb.toString());
	}
	@Test
	public void addWorks() {
		IList<String> theList = new SortedList<>();
		theList.add("Fish");
		theList.add("Sheep");
		theList.add("Duck");
		theList.add("Horse");
		StringBuilder sb = new StringBuilder();
		for (String s : theList) {
			sb.append(s);
		}
		assertEquals("DuckFishHorseSheep", sb.toString());
	}
	@Test
	public void addOneItemWithComparator() {
		IList<String> theList = new SortedList<>(
			(s1, s2) -> s2.compareTo(s1)
		);
		theList.add("Duck");
		assertEquals("Duck", theList.getFirst());
	}
	@Test
	public void addTwoItemsAZWithComparator() {
		IList<String> theList = new SortedList<>(
			(s1, s2) -> s2.compareTo(s1)
		);
		theList.add("Duck");
		theList.add("Fish");
		assertEquals("Fish", theList.removeFirst());
		assertEquals("Duck", theList.removeFirst());
	}
	@Test
	public void addTwoItemsZAWithComparator() {
		IList<String> theList = new SortedList<>(
			(s1, s2) -> s2.compareTo(s1)
		);
		theList.add("Fish");
		theList.add("Duck");
		assertEquals("Fish", theList.removeFirst());
		assertEquals("Duck", theList.removeFirst());
	}
	@Test
	public void addItemsMixedWithComparator() {
		IList<String> theList = new SortedList<>(
			(s1, s2) -> s2.compareTo(s1)
		);
		theList.add("Fish");
		theList.add("Sheep");
		theList.add("Dog");
		theList.add("Horse");
		theList.add("Cat");
		theList.add("Duck");
		StringBuilder sb = new StringBuilder();
		for (String s : theList) {
			sb.append(s);
		}
		assertEquals("SheepHorseFishDuckDogCat", sb.toString());
	}
	@Test
	public void addItemsMixedWidthDupsWithComparator() {
		IList<String> theList = new SortedList<>(
			(s1, s2) -> s2.compareTo(s1)
		);
		theList.add("Fish");
		theList.add("Fish");
		theList.add("Cat");
		theList.add("Duck");
		theList.add("Sheep");
		theList.add("Dog");
		theList.add("Horse");
		theList.add("Cat");
		theList.add("Duck");
		StringBuilder sb = new StringBuilder();
		for (String s : theList) {
			sb.append(s);
		}
		assertEquals("SheepHorseFishFishDuckDuckDogCatCat", sb.toString());
	}
}

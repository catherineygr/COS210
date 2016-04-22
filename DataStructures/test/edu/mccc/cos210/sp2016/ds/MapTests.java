package edu.mccc.cos210.sp2016.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MapTests {
	@Test
	public void newMapIsEmpty() {
		IMap<String, String> theMap = new Map<>();
		assertTrue(theMap.isEmpty());
		assertEquals(0, theMap.getSize());
	}
	@Test
	public void addToMapSizeIsCorrect() {
		IMap<String, String> theMap = new Map<>();
		theMap.put("Feline", "Cat");
		assertFalse(theMap.isEmpty());
		assertEquals(1, theMap.getSize());
	}
	@Test
	public void addTwoToMapSizeIsCorrect() {
		IMap<String, String> theMap = new Map<>();
		theMap.put("Feline", "Cat");
		theMap.put("Canine", "Dog");
		assertEquals(2, theMap.getSize());
	}
	@Test
	public void addWithDupToMapSizeIsCorrect() {
		IMap<String, String> theMap = new Map<>();
		theMap.put("Feline", "Cat");
		theMap.put("Feline", "Cat");
		theMap.put("Feline", "Lion");
		assertEquals(1, theMap.getSize());
	}
	@Test
	public void addTheGetIsCorrect() {
		IMap<String, String> theMap = new Map<>();
		theMap.put("Feline", "Cat");
		assertEquals("Cat", theMap.get("Feline"));
	}
	@Test
	public void containsKeyTrue() {
		IMap<String, String> theMap = new Map<>();
		theMap.put("Feline", "Cat");
		theMap.put("Canine", "Dog");
		assertTrue(theMap.containsKey("Feline"));
		assertTrue(theMap.containsKey("Canine"));
	}
	@Test
	public void containsKeyFalse() {
		IMap<String, String> theMap = new Map<>();
		theMap.put("Feline", "Cat");
		theMap.put("Canine", "Dog");
		assertFalse(theMap.containsKey("Porcine"));
		assertFalse(theMap.containsKey("Bovine"));
	}
	@Test
	public void getOfMissingKeyReturnsNull() {
		IMap<String, String> theMap = new Map<>();
		theMap.put("Feline", "Cat");
		theMap.put("Canine", "Dog");
		theMap.put("Porcine", "Pig");
		theMap.put("Bovine", "Cow");
		assertEquals("Pig", theMap.get("Porcine"));
		assertEquals(null, theMap.get("Musteline"));
		theMap.put("Musteline", "Polecat");
		assertEquals("Polecat", theMap.get("Musteline"));
	}
	@Test
	public void iterateSet() {
		IMap<String, String> theMap = new Map<>();
		theMap.put("Feline", "Cat");
		theMap.put("Canine", "Dog");
		theMap.put("Porcine", "Pig");
		theMap.put("Bovine", "Cow");
		theMap.put("Musteline", "Polecat");
		StringBuffer sb = new StringBuffer();
		for (String key : theMap.keySet()) {
			String value = theMap.get(key);
			System.out.println(key + " : " + value);
			sb.append(value);
		}
		assertEquals(19, sb.toString().length());
	}
}

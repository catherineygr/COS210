package edu.mccc.cos210.sp2016.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTests {
	@Test
	public void arrayHasCorrectSize() {
		IArray<String> theArray = new Array<>(1);
		assertEquals(1, theArray.getSize());
		theArray = new Array<>(2);
		assertEquals(2, theArray.getSize());
		theArray = new Array<>(100);
		assertEquals(100, theArray.getSize());
	}
	@Test
	public void loadArrayThenIterate() {
		IArray<String> theArray = new Array<>(8);
		assertEquals(8, theArray.getSize());
		theArray.set(0, "Dog");
		theArray.set(1, "Cat");
		theArray.set(2, "Mouse");
		theArray.set(3, "Sheep");
		theArray.set(4, "Frog");
		theArray.set(5, "Fox");
		theArray.set(6, "Horse");
		theArray.set(7, "Coyote");
		StringBuilder sb = new StringBuilder();
		for (String s : theArray) {
			sb.append(s);
		}
		assertEquals("DogCatMouseSheepFrogFoxHorseCoyote", sb.toString());
	}
	@Test
	public void getIsCorrect() {
		IArray<String> theArray = new Array<>(8);
		assertEquals(8, theArray.getSize());
		theArray.set(0, "Dog");
		theArray.set(1, "Cat");
		theArray.set(2, "Mouse");
		theArray.set(3, "Sheep");
		theArray.set(4, "Frog");
		theArray.set(5, "Fox");
		theArray.set(6, "Horse");
		theArray.set(7, "Coyote");
		assertEquals("Sheep", theArray.get(3));
		assertEquals("Dog", theArray.get(0));
		assertEquals("Coyote", theArray.get(7));
	}
	@Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
	public void outOfBoundsIndex() {
		IArray<String> theArray = new Array<>(8);
		assertEquals(8, theArray.getSize());
		theArray.set(0, "Dog");
		theArray.set(1, "Cat");
		theArray.set(2, "Mouse");
		theArray.set(3, "Sheep");
		theArray.set(4, "Frog");
		theArray.set(5, "Fox");
		theArray.set(6, "Horse");
		theArray.set(7, "Coyote");
		theArray.get(8);
	}
}

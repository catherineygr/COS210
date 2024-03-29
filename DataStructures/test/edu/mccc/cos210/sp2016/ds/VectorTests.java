package edu.mccc.cos210.sp2016.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class VectorTests {
	@Test
	public void arrayHasCorrectCapacityAndSize() {
		IVector<String> theArray = new Vector<>(1);
		assertEquals(1, theArray.getSize());
		assertEquals(1, theArray.getCapacity());
		theArray = new Vector<>(2);
		assertEquals(2, theArray.getSize());
		assertEquals(2, theArray.getCapacity());
		theArray = new Vector<>(50, 100);
		assertEquals(50, theArray.getSize());
		assertEquals(100, theArray.getCapacity());
		theArray = new Vector<>(100);
		assertEquals(100, theArray.getSize());
		assertEquals(100, theArray.getCapacity());
	}
	@Test
	public void loadArrayThenIterate() {
		IVector<String> theArray = new Vector<>(8);
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
		IVector<String> theArray = new Vector<>(8);
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
	@Test(expected = java.lang.IndexOutOfBoundsException.class)
	public void outOfBoundsIndex() {
		IVector<String> theArray = new Vector<>(8);
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
	@Test
	public void increaseCapacity() {
		IVector<String> theArray = new Vector<>(0, 1);
		assertEquals(0, theArray.getSize());
		assertEquals(1, theArray.getCapacity());
		theArray.pushBack("Dog");
		assertEquals(1, theArray.getSize());
		assertEquals(1, theArray.getCapacity());
		theArray.pushBack("Cat");
		assertEquals(2, theArray.getSize());
		assertEquals(2, theArray.getCapacity());
		theArray.pushBack("Mouse");
		assertEquals(3, theArray.getSize());
		assertEquals(4, theArray.getCapacity());
		theArray.pushBack("Sheep");
		assertEquals(4, theArray.getSize());
		assertEquals(4, theArray.getCapacity());
		theArray.pushBack("Frog");
		assertEquals(5, theArray.getSize());
		assertEquals(8, theArray.getCapacity());
	}
	@Test
	public void shrinkToFitWorks() {
		IVector<String> theArray = new Vector<>(0, 1);
		theArray.pushBack("Dog");
		theArray.pushBack("Cat");
		theArray.pushBack("Mouse");
		theArray.pushBack("Sheep");
		theArray.pushBack("Frog");
		assertEquals(5, theArray.getSize());
		assertEquals(8, theArray.getCapacity());
		theArray.shrinkToFit();
		assertEquals(5, theArray.getSize());
		assertEquals(5, theArray.getCapacity());		
		theArray.pushBack("Horse");
		assertEquals(6, theArray.getSize());
		assertEquals(10, theArray.getCapacity());		
	}
}

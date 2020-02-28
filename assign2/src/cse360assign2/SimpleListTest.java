package cse360assign2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SimpleListTest {

	/**
	 * test add
	 */
	@Test
	void testAdd() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		assertEquals(list.toString(), "4 3 2 1");
	}

	/**
	 * test add on a full list
	 */
	@Test
	void testAddFull() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		assertEquals(list.toString(), "12 11 10 9 8 7 6 5 4 3 2 1");
	}

	/**
	 * test remove
	 */
	@Test
	void testRemove() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.remove(9);
		list.remove(1);
		assertEquals(list.toString(), "8 7 6 5 4 3 2");
	}

	/**
	 * test remove element not in list
	 */
	@Test
	void testRemoveNotInList() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.remove(10);
		assertEquals(list.toString(), "9 8 7 6 5 4 3 2 1");
	}

	/**
	 * test length with empty list
	 */
	@Test
	void testLengthEmpty() {
		SimpleList list = new SimpleList();
		assertEquals(list.LENGTH, 10);
	}

	/**
	 * test length with add
	 */
	@Test
	void testLengthAdd() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		assertEquals(list.LENGTH, 15);
	}

	/**
	 * test length with remove
	 */
	@Test
	void testLengthRemove() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.remove(9);
		list.remove(1);
		assertEquals(list.LENGTH, 7);
	}

	/**
	 * test count with empty list
	 */
	@Test
	void testCountEmpty() {
		SimpleList list = new SimpleList();
		assertEquals(list.count(), 0);
	}

	/**
	 * test count with add
	 */
	@Test
	void testCountAdd() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		assertEquals(list.count(), 4);
	}

	/**
	 * test count with add on a full list
	 */
	@Test
	void testCountAddFull() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		assertEquals(list.count(), 12);
	}

	/**
	 * test count with remove
	 */
	@Test
	void testCountRemove() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.remove(9);
		list.remove(1);
		assertEquals(list.count(), 8);
	}

	/**
	 * test count with remove from an empty list
	 */
	@Test
	void testCountRemoveEmpty() {
		SimpleList list = new SimpleList();
		list.remove(1); // should do nothing
		assertEquals(list.count(), 0);
	}

	/**
	 * test toString with empty list
	 */
	@Test
	void testToStringEmpty() {
		SimpleList list = new SimpleList();
		assertEquals(list.toString(), "");
	}

	/**
	 * test toString with remove on an empty list
	 */
	@Test
	void testToStringRemoveEmpty() {
		SimpleList list = new SimpleList();
		list.remove(1); // should do nothing
		assertEquals(list.toString(), "");
	}

	/**
	 * test search with an empty list
	 */
	@Test
	void testSearchEmpty() {
		SimpleList list = new SimpleList();
		assertEquals(list.search(1), -1);
	}

	/**
	 * test search with add
	 */
	@Test
	void testSearchAdd() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		assertEquals(list.search(1), 3);
	}

	/**
	 * test search with removed element
	 */
	@Test
	void testSearchRemoved() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.remove(9);
		assertEquals(list.search(9), -1);
	}

}

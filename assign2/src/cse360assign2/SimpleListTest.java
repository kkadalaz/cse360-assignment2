package cse360assign2;

import org.junit.jupiter.api.Test;

class SimpleListTest {

	/**
	 * tests SimpleList.add()
	 */
	@Test
	void testAdd() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(4);
		assert list.toString().equals("4 5 2 1");
	}
	
	/**
	 * tests SimpleList.remove()
	 */
	@Test
	void testRemove() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(4);
		list.remove(4);
		list.remove(1);
		assert list.toString().equals("5 2");
	}

	/**
	 * tests SimpleList.count()
	 */
	@Test
	void testCount() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(4);
		assert list.count() == 4;
	}

	/**
	 * tests SimpleList.toString()
	 */
	@Test
	void testToString() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(4);
		assert list.toString().equals("4 5 2 1");
	}

	/**
	 * tests SimpleList.search()
	 */
	@Test
	void testSearch() {
		SimpleList list = new SimpleList();
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(4);
		assert list.search(1) == 3;
	}

}

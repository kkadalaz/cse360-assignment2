/*
 * Name: Kesav Kadalazhi
 * ID: 1213462586
 * Assignment 1
 * 
 * this file contains the SimpleList class
 */

package cse360assign2;

/**
 * this is a list of integers
 * <p>
 * <ul>
 * <li>this holds 10 integers, initially
 * <li>this can increase its length, if the list is full
 * <li>this can decrease its length, if the list contains many empty elements
 * </ul>
 * </p>
 * 
 * @author Kesav Kadalazhi
 */
public class SimpleList {

	private int[] list;
	private int count;

	public int LENGTH;

	/**
	 * instantiate list
	 * <p>
	 * <ul>
	 * <li>initial length is 10
	 * <li>initial list contains no elements
	 * </ul>
	 * </p>
	 */
	public SimpleList() {
		LENGTH = 10;
		list = new int[LENGTH];
	}

	/**
	 * access the first element in the list
	 * 
	 * @return the first element in the list, -1 if not found
	 */
	public int first() {
		// if list empty, return -1, else return first element
		return count == 0 ? -1 : list[0];
	}

	/**
	 * add element to the start of the list
	 * <p>
	 * <ul>
	 * <li>push all other elements down
	 * <li>increase the size of the list, if the list is full
	 * </ul>
	 * </p>
	 * 
	 * @param element the element to be added
	 */
	public void add(int element) {
		// if list is full
		if (count == LENGTH) {
			// expand length
			int newlen = (int) (LENGTH * 1.5);
			// create bigger temporary list
			int[] newlist = new int[newlen];
			// loop backwards through original list
			for (int counter = LENGTH; counter > 0; counter--) {
				// copy to new list
				// move each element down one spot
				newlist[counter] = list[counter - 1];
			}
			// update length
			LENGTH = newlen;
			// update list
			list = newlist;
		} else {
			// loop backwards
			for (int counter = LENGTH - 1; counter > 0; counter--) {
				// move each element down one spot
				list[counter] = list[counter - 1];
			}
		}

		// insert the element at the start of the list
		list[0] = element;

		// if list is not yet full
		if (count < LENGTH) {
			// update count
			count++;
		}
	}

	/**
	 * add element to the end of the list
	 * <p>
	 * <ul>
	 * <li>do not modify any other elements
	 * <li>increase the size of the list, if the list is full
	 * </ul>
	 * </p>
	 * 
	 * @param element the element to be appended
	 */
	public void append(int element) {
		// if list is full
		if (count == LENGTH) {
			// expand length
			int newlen = (int) (LENGTH * 1.5);
			// create bigger temporary list
			int[] newlist = new int[newlen];
			// loop backwards through original list
			for (int counter = 0; counter < LENGTH; counter++) {
				// copy to new list
				newlist[counter] = list[counter];
			}
			// update length
			LENGTH = newlen;
			// update list
			list = newlist;
		}

		// add element to the end of the list
		list[count] = element;

		// if list is not yet full
		if (count < LENGTH) {
			// update count
			count++;
		}
	}

	/**
	 * remove element from list, if found
	 * <p>
	 * <ul>
	 * <li>move all following elements up, if found
	 * <li>do nothing, if not found
	 * <li>decrease the size of the list, if list has more than 25% empty places
	 * </ul>
	 * </p>
	 * 
	 * @param element the element to be removed
	 */
	public void remove(int element) {
		// search for the element
		int location = search(element);

		// if found
		if (location != -1) {
			// loop over list
			for (int counter = location; counter < LENGTH - 1; counter++) {
				// move each element up one spot
				list[counter] = list[counter + 1];
			}
			// remove the last element
			list[LENGTH - 1] = 0;

			// if list is not already empty
			if (count > 0) {
				// update count
				count--;
			}
		}

		// if the list is more than 25% zeroes
		// numzeroes / length < 0.25
		// numzeroes / length < 1/4
		// (length - count) / length < 1/4
		// 4*(length - count) < 1*length
		// 4*length - 4*count < length
		// 4*length - length < 4*count
		// 3*length > 4*count
		// and if the list is not just one element
		if (3 * LENGTH > 4 * count && LENGTH != 1) {
			// reduce the length of the list
			int newlen = (int) (LENGTH * 0.75);
			// create bigger temporary list
			int[] newlist = new int[newlen];
			// loop through the original list
			for (int counter = 0; counter < newlen; counter++) {
				// copy elements over
				newlist[counter] = list[counter];
			}
			// update length
			LENGTH = newlen;
			// update list
			list = newlist;
		}
	}

	/**
	 * search in list
	 * 
	 * @param element the element to search
	 * @return index of element, -1 if not found
	 */
	public int search(int element) {
		// index of the element
		int location = -1;
		// whether element has been found
		boolean found = false;

		// loop over list
		for (int counter = 0; counter < LENGTH; counter++) {
			// if element has not been found yet
			// and if current element matches given element
			if (!found && list[counter] == element) {
				// element found
				found = true;
				// update location
				location = counter;
			}
		}
		// index of the element
		return location;
	}

	/**
	 * access the number of elements in the list
	 * 
	 * @return number of elements in the list
	 */
	public int count() {
		// count is modified in other methods
		return count;
	}

	/**
	 * string-ify list
	 * 
	 * @return string version of the list
	 */
	public String toString() {
		// StringBuilder is more efficient
		StringBuilder toString = new StringBuilder();
		// loop over list
		for (int counter = 0; counter < LENGTH; counter++) {
			// if element is not empty
			if (list[counter] != 0) {
				// add element and space separator
				toString.append(list[counter]).append(' ');
			}
		}
		// remove trailing space
		return toString.toString().trim();
	}

}

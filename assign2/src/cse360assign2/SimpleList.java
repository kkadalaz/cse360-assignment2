/*
 * Name: Kesav Kadalazhi
 * ID: 1213462586
 * Assignment 1
 * 
 * this file contains the SimpleList class
 */

package cse360assign2;

/**
 * this is the SimpleList class it holds 10 integers
 * 
 * @author Kesav Kadalazhi
 */
public class SimpleList {

	private int[] list;
	private int count;
	private int LENGTH;

	/**
	 * instantiates the list
	 */
	public SimpleList() {
		LENGTH = 10;
		list = new int[LENGTH];
	}

	/**
	 * adds element to the start of the list, pushing all other elements down
	 * 
	 * @param element the element to be added
	 */
	public void add(int element) {
		// loop backwards
		for (int counter = LENGTH - 1; counter > 0; counter--) {
			// move each element down one spot
			list[counter] = list[counter - 1];
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
	 * removes an element from the last, moving all following elements up
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
		}

		// if list is not already empty
		if (count > 0) {
			// update count
			count--;
		}
	}

	/**
	 * searches for a given element in the list
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
	 * @return number of elements in the list
	 */
	public int count() {
		return count;
	}

	/**
	 * @return string version of the list
	 */
	public String toString() {
		StringBuilder toString = new StringBuilder();
		for (int counter = 0; counter < LENGTH; counter++) {
			if (list[counter] != 0) {
				toString.append(list[counter]).append(' ');
			}
		}
		return toString.toString().trim();
	}

}

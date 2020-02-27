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
 *
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
	 * adds the element to the start of the list pushes all other elements down
	 * 
	 * @param element
	 */
	public void add(int element) {
		for (int counter = LENGTH - 1; counter > 0; counter--) {
			list[counter] = list[counter - 1];
		}
		list[0] = element;

		// if list is not yet full
		if (count < LENGTH) {
			// update count
			count++;
		}
	}

	/**
	 * removes an element from the last moves all following elements up
	 * 
	 * @param element
	 */
	public void remove(int element) {
		int location = search(element);
		if (location != -1) {
			for (int counter = location; counter < LENGTH - 1; counter++) {
				list[counter] = list[counter + 1];
			}
			list[9] = 0;
		}
		// if list is not already empty
		if (count > 0) {
			// update count
			count--;
		}
	}

	/**
	 * searches for a given element in the list if not found, return -1
	 * 
	 * @param element
	 * @return location of element
	 */
	public int search(int element) {
		int location = -1;
		boolean found = false;

		for (int counter = 0; counter < LENGTH; counter++) {
			if (!found && list[counter] == element) {
				found = true;
				location = counter;
			}
		}
		return location;
	}

	/**
	 * @return number of elements in the list
	 */
	public int count() {
		return count;
	}

	/**
	 * returns a string version of the list
	 */
	public String toString() {
		String toString = "";
		for (int counter = 0; counter < LENGTH - 1; counter++) {
			if (list[counter] != 0) {
				toString += list[counter];
				toString += " ";
			}
		}
		if (list[LENGTH - 1] != 0) {
			toString += list[LENGTH - 1];
		}
		return toString.trim();
	}

}

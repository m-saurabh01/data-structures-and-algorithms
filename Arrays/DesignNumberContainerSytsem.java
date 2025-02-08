package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
 * 			Leetcode Medium 2349. Design a Number Container System
 * 
Design a number container system that can do the following:

Insert or Replace a number at the given index in the system.
Return the smallest index for the given number in the system.
Implement the NumberContainers class:

NumberContainers() Initializes the number container system.
void change(int index, int number) Fills the container at index with the number. If there is already a number at that index, replace it.
int find(int number) Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.
*/

public class DesignNumberContainerSytsem {

	
	public void change(int index, int number) {
	    if (indexToNumbers.containsKey(index)) {
	      final int originalNumber = indexToNumbers.get(index);
	      numberToIndices.get(originalNumber).remove(index);
	      if (numberToIndices.get(originalNumber).isEmpty())
	        numberToIndices.remove(originalNumber);
	    }
	    indexToNumbers.put(index, number);
	    numberToIndices.putIfAbsent(number, new TreeSet<>());
	    numberToIndices.get(number).add(index);
	  }

	  public int find(int number) {
	    if (numberToIndices.containsKey(number))
	      return numberToIndices.get(number).first();
	    return -1;
	  }

	  private Map<Integer, TreeSet<Integer>> numberToIndices = new HashMap<>();
	  private Map<Integer, Integer> indexToNumbers = new HashMap<>();
}

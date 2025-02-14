package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * 			Leetcode Medium 1352. Product of the Last K Numbers
 * 
Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.

Implement the ProductOfNumbers class:

ProductOfNumbers() Initializes the object with an empty stream.
void add(int num) Appends the integer num to the stream.
int getProduct(int k) Returns the product of the last k numbers in the current list. You can assume that always the current list has at least k numbers.
The test cases are generated so that, at any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.

 

Example:

Input
["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
[[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]

Output
[null,null,null,null,null,null,20,40,0,null,32]
*/
 public class ProductOfNumbers {

	
	public ProductOfNumbers() {
	    prefix = new ArrayList<>(List.of(1));
	  }

	  public void add(int num) {
	    if (num == 0)
	      prefix = new ArrayList<>(List.of(1));
	    else
	      prefix.add(prefix.get(prefix.size() - 1) * num);
	  }

	  public int getProduct(int k) {
	    return k >= prefix.size() ? 0
	                              : prefix.get(prefix.size() - 1) / prefix.get(prefix.size() - k - 1);
	  }

	  private List<Integer> prefix = new ArrayList<>();

}

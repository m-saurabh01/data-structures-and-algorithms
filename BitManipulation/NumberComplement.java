package BitManipulation;

/*
						Number Complement Leetcode 476 Easy

The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.

 

Example 1:
Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:
Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 

Constraints:

1 <= num < 2^31

*/
public class NumberComplement {
	

	public static void main(String[] args) {
		
		int num=5;
		
		int complement=findComplement(num);
		System.out.println(complement);
	}
	
	//We primarily have to find the mask to xor it to flip the value
	// 1^1->0 1^0->0 0^0->0 0^1->1
	//Now we count num bits by below function and create the mask and xor it 
	public static int findComplement(int num) {
		int bits = numBits(num);
		int mask = (1 << bits) - 1;
		return num ^ mask;
	}
	
	
	public static int numBits(int num) {
		int count = 0;

		while (num != 0) {
			num = num >> 1;
			count++;
		}

		return count;
	}

}

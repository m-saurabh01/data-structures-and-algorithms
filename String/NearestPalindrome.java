package String;

import java.util.ArrayList;
import java.util.List;

/*
						Find the Closest Palindrome (Leetcode 564) HARD

Given a string n representing an integer, return the closest integer (not including itself), which is a palindrome. If there is a tie, return the smaller one.

The closest is defined as the absolute difference minimized between two integers.

 

Example 1:

Input: n = "123"
Output: "121"

Example 2:

Input: n = "1"
Output: "0"
Explanation: 0 and 2 are the closest palindromes but we return the smallest which is 0.
 

Constraints:

1 <= n.length <= 18
n consists of only digits.
n does not have leading zeros.
n is representing an integer in the range [1, 10^18 - 1].

*/

public class NearestPalindrome {

	//Function takes half of number and make it palindrome
	long func(long first, boolean isEven) {
		long res = first;
		if (!isEven)
			first /= 10;

		while (first > 0) {
			long dig = first % 10;
			res = (res * 10) + dig;
			first /= 10;
		}

		return res;
	}

	public String nearestPalindromic(String n) {

		int len = n.length();

		int mid = (len % 2 == 0) ? len / 2 : len / 2 + 1;

		long first = Long.valueOf(n.substring(0, mid));

		List<Long> pals = new ArrayList<>();

		pals.add(func(first, len % 2 == 0));
		pals.add(func(first + 1, len % 2 == 0));
		pals.add(func(first - 1, len % 2 == 0));
		pals.add((long) Math.pow(10, len) + 1);
		pals.add((long) Math.pow(10, len - 1) - 1);

		long diff = Long.MAX_VALUE;
		long res = Long.MAX_VALUE;
		long s = Long.valueOf(n);

		for (long a : pals) {
			if (a == s)
				continue;
			if (Math.abs(s - a) < diff) {
				diff = Math.abs(s - a);
				res = a;
			} else if (Math.abs(s - a) == diff) {
				res = Math.min(res, a);
			}
		}

		return String.valueOf(res);
	}
	
	public static void main(String[] args) {
		
		
		NearestPalindrome nearPal=new NearestPalindrome();
		
		//Outputs 121
		System.out.println(nearPal.nearestPalindromic("123"));
	}
}

package String;


/*
  			Longest Common Prefix LeetCode 14 : Easy
  
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/
public class LongestCommonPrefix {
	

	static String longestCommonPrefix(String[] strs) {

		if (strs.length == 0)
			return "";

		String max = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int a = 0, b = 0;
			while (a < max.length() && b < strs[i].length() && max.charAt(a) == strs[i].charAt(b)) {
				a++;
				b++;
			}
			max = max.substring(0, a);

		}

		return max;
	}

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };

		// Outputs 'fl'
		System.out.println(longestCommonPrefix(strs));
	}

}

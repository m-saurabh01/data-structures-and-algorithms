package String;

import java.util.PriorityQueue;


/*			Leetcode Medium 1405. Longest Happy String
 * 
 * 
A string s is called happy if it satisfies the following conditions:

s only contains the letters 'a', 'b', and 'c'.
s does not contain any of "aaa", "bbb", or "ccc" as a substring.
s contains at most a occurrences of the letter 'a'.
s contains at most b occurrences of the letter 'b'.
s contains at most c occurrences of the letter 'c'.
Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.
Example 2:

Input: a = 7, b = 1, c = 0
Output: "aabaa"
Explanation: It is the only correct answer in this case.
 */
public class LongestHappyString {
	
	
	public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[1] - x[1]);
      
        
        if (a > 0) {
            maxHeap.offer(new int[] {'a', a});
        }
        if (b > 0) {
            maxHeap.offer(new int[] {'b', b});
        }
        if (c > 0) {
            maxHeap.offer(new int[] {'c', c});
        }

      
        StringBuilder result = new StringBuilder();
      
        
        while (!maxHeap.isEmpty()) {
            
            int[] current = maxHeap.poll();
            int length = result.length();
            
            if (length >= 2 && result.charAt(length - 1) == current[0] && result.charAt(length - 2) == current[0]) {
                
                if (maxHeap.isEmpty()) {
                    break;
                }
                
                int[] next = maxHeap.poll();
                result.append((char) next[0]);
                
                if (next[1] > 1) {
                    next[1]--;
                    maxHeap.offer(next);
                }
                
                maxHeap.offer(current);
            } else {
                
                result.append((char) current[0]);
                
                if (current[1] > 1) {
                    current[1]--;
                    maxHeap.offer(current);
                }
            }
        }

        
        return result.toString();
        
    }

}

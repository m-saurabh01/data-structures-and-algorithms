package BitManipulation;

/*
 * 						Leetcode Medium 2683. Neighboring Bitwise XOR
 * 
A 0-indexed array derived with length n is derived by computing the bitwise XOR (⊕) of adjacent values in a binary array original of length n.

Specifically, for each index i in the range [0, n - 1]:

If i = n - 1, then derived[i] = original[i] ⊕ original[0].
Otherwise, derived[i] = original[i] ⊕ original[i + 1].
Given an array derived, your task is to determine whether there exists a valid binary array original that could have formed derived.

Return true if such an array exists or false otherwise.

A binary array is an array containing only 0's and 1's
 

Example 1:

Input: derived = [1,1,0]
Output: true
Explanation: A valid original array that gives derived is [0,1,0].
derived[0] = original[0] ⊕ original[1] = 0 ⊕ 1 = 1 
derived[1] = original[1] ⊕ original[2] = 1 ⊕ 0 = 1
derived[2] = original[2] ⊕ original[0] = 0 ⊕ 0 = 0

*/

public class NeigbouringBitwiseXOR {
	
	public boolean doesValidArrayExist(int[] der) {
        int n=der.length;

        int[] res=new int[n];

        res[0]=0;

        for(int i=1;i<n;i++){
            res[i]=res[i-1]^der[i-1];
        }

        if((res[n-1]^res[0])==der[n-1])return true;

        res[0]=1;

        for(int i=1;i<n;i++){
            res[i]=res[i-1]^der[i-1];
        }

        if((res[n-1]^res[0])==der[n-1])return true;

        return false;
        
    }

}

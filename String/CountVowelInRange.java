package String;

/*
 * 			Leetcode Medium 2559. Count Vowel Strings in Ranges
 * 
 * 
You are given a 0-indexed array of strings words and a 2D array of integers queries.

Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.

Return an array ans of size queries.length, where ans[i] is the answer to the ith query.

Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2,3,0]
Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
The answer to the query [0,2] is 2 (strings "aba" and "ece").
to query [1,4] is 3 (strings "ece", "aa", "e").
to query [1,1] is 0.
We return [2,3,0].
*/

public class CountVowelInRange {
	
	public int[] vowelStrings(String[] wo, int[][] qs) {
        int n=qs.length;
        int res[]=new int[n];

        int[] prefSum=new int[wo.length];

        prefSum[0]=(isVowel(wo[0])?1:0);

        for(int i=1;i<wo.length;i++){
            if(isVowel(wo[i])){
                prefSum[i]=prefSum[i-1]+1;
            }else{
                prefSum[i]=prefSum[i-1];
            }
        }
   
        for(int i=0;i<n;i++){  
            
                res[i]=prefSum[qs[i][1]]-(qs[i][0]-1<0?0:prefSum[qs[i][0]-1]);        
        }

        return res;
        
    }

    boolean isVowel(String str){
        int n=str.length()-1;
        str=str.toLowerCase();
        boolean l=str.charAt(0)=='a'||str.charAt(0)=='e'||str.charAt(0)=='i'||str.charAt(0)=='o'||str.charAt(0)=='u';
        boolean r=str.charAt(n)=='a'||str.charAt(n)=='e'||str.charAt(n)=='i'||str.charAt(n)=='o'||str.charAt(n)=='u';

        return l&&r;
    }

}

package String;


/*				Zigzag Conversion Leetcode Medium 6
 * 
 * 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
*/

public class ZigZagConversion {
	
public String convert(String s, int nr) {
        
        if(nr==1)return s;
        
        String res="";

        for(int i=0;i<nr;i++){

            for(int j=i;j<s.length();j+=2*(nr-1)){
                res+=s.charAt(j);

                if(i>0 && i<nr-1 && j+2*(nr-1)-2*i<s.length()){
                    res+=s.charAt(j+2*(nr-1)-2*i);
                }

            }
        }

        return res;
    }

}

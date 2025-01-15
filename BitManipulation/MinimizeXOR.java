package BitManipulation;

/*
 * 			Leetcode Medium 2429. Minimize XOR
 * 
Given two positive integers num1 and num2, find the positive integer x such that:

x has the same number of set bits as num2, and
The value x XOR num1 is minimal.
Note that XOR is the bitwise XOR operation.

Return the integer x. The test cases are generated such that x is uniquely determined.

The number of set bits of an integer is the number of 1's in its binary representation.

 

Example 1:

Input: num1 = 3, num2 = 5
Output: 3
Explanation:
The binary representations of num1 and num2 are 0011 and 0101, respectively.
The integer 3 has the same number of set bits as num2, and the value 3 XOR 3 = 0 is minimal.
*/

public class MinimizeXOR {

	boolean isSet(int x,int bit){
        return (x&(1<<bit))==0;
    }
    public int minimizeXor(int num1, int num2) {

        int x=num1;

        int reqBit=Integer.bitCount(num2);
        int curBit=Integer.bitCount(x);

        int bit=0;

        if(reqBit>curBit){

            while(reqBit>curBit){
                
                if(isSet(x,bit)){
                    
                    x|=(1<<bit);
                    curBit++;
                }
                bit++;
            }
        } else if(reqBit<curBit){

            while(reqBit<curBit){
                if(!isSet(x,bit)){
                    x&=~(1<<bit);
                    curBit--;
                }
                bit++;
            }
        }
        
        return x;
    }
}

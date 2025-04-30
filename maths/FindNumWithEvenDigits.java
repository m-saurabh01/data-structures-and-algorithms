package Maths;

public class FindNumWithEvenDigits {
	/*
	 * 	1295. Find Numbers with Even Number of Digits
	 */	
public int findNumbers(int[] nums) {
        
        int cnt=0;
        
        for(int n:nums){
            if((n>9 && n<100)||(n>999 && n<10000)||n==100000)cnt++;
        }
        
        return cnt;
        
    }

}

package Maths;

/*
		2145. Count the Hidden Sequences
*/
public class CountHiddenSequences {
	
	
	 public int numberOfArrays(int[] differences, int lower, int upper) {

	        int cur=0,max=0,min=0;

	        for(int d:differences){
	            cur=d+cur;

	            min=Math.min(min,cur);
	            max=Math.max(max,cur);

	            if((upper-max)-(lower-min)+1<=0){
	                return 0;
	            }
	        }

	        return (upper-max)-(lower-min)+1;
	        
	    }

}

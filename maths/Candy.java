package Maths;

import java.util.Arrays;

/*
				135. Candy
*/

public class Candy {
	
	public int candy(int[] rat) {
	      
	      int n=rat.length;
	      int ltr[]=new int[rat.length];
	      int rtl[]=new int[rat.length];
	      Arrays.fill(ltr,1);
	      Arrays.fill(rtl,1);

	      for(int i=1;i<n;i++){

	          if(rat[i]>rat[i-1]){
	              ltr[i]=ltr[i-1]+1;
	          }
	      }

	       for(int i=n-2;i>=0;i--){

	          if(rat[i]>rat[i+1]){
	              rtl[i]=rtl[i+1]+1;
	          }
	      }
	      int res=0;

	      for(int i=0;i<n;i++){
	          res+=Math.max(rtl[i],ltr[i]);
	      }

	        return res;
	    }

}

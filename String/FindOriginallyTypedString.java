package String;

/*
		3330. Find the Original Typed String I
*/
public class FindOriginallyTypedString {
	
	public int possibleStringCount(String word) {

        int res=1,i=0;

        while(i<word.length()){
            
            int j=i+1;

            while(j<word.length() && word.charAt(i)==word.charAt(j))j++;

            res+=(j-i-1);
            i=j;
        }
        
        return res;
    }

}

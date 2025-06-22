package String;

/*
		2138. Divide a String Into Groups of Size k
*/
public class DivideStringInGroupsOfSizeK {
	
	public String[] divideString(String s, int k, char fill) {

        int n=s.length()/k;
        if(s.length()%k!=0)n++;
        
        int i=0,x=0;

        String[] res=new String[n];

        while(i<s.length()){

            String ele=s.substring(i,Math.min(i+k,s.length()));

            if(ele.length()<k){
                ele+=String.valueOf(fill).repeat(k-ele.length());
            }

            res[x++]=ele;
            i+=k;

        }


        return res;
    }

}

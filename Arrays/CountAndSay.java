package Arrays;

/*
		38. Count and Say
*/
public class CountAndSay {
	
	public String countAndSay(int n) {
        if(n==1)return "1";

        String say=countAndSay(n-1);
        String res="";

        for(int i=0;i<say.length();i++){
            char ch=say.charAt(i);
            int cnt=1;
            while(i<say.length()-1 && say.charAt(i)==say.charAt(i+1)){
                cnt++;
                i++;
            }
            res+=String.valueOf(cnt)+ch;
        }

        return res;
        
    }

}

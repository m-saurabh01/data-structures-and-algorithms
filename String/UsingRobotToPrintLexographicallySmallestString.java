package String;

/*
		2434. Using a Robot to Print the Lexicographically Smallest String
*/
public class UsingRobotToPrintLexographicallySmallestString {
	
	public String robotWithString(String str) {

        StringBuilder s=new StringBuilder();
        StringBuilder t=new StringBuilder();

        int n=str.length();

        char[] ch=new char[n];
        ch[n-1]=str.charAt(n-1);

        for(int i=n-2;i>=0;i--){
            ch[i]=ch[i+1]>=str.charAt(i)?str.charAt(i):ch[i+1];
        }

        int i=0;
        while(i<n){
            t.append(str.charAt(i));

            char min=i+1<n?ch[i+1]:str.charAt(i);

            while(!t.isEmpty() && t.charAt(t.length()-1)<=min){
                s.append(t.charAt(t.length()-1));
                t.deleteCharAt(t.length()-1);
            }

            i++;
        }

        while(!t.isEmpty()){
            s.append(t.charAt(t.length()-1));
            t.deleteCharAt(t.length()-1);
        }



        return s.toString();
    }

}

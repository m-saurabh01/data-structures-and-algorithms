package Maths;

public class CountSymmetricInteger {
	
	public int countSymmetricIntegers(int low, int high) {

        int res=0;

        for(int i=low;i<=high;i++){
            if(isSym(i))res++;
        }
        
        return res;
    }

    boolean isSym(int num){

        String s=String.valueOf(num);

        if(s.length()%2!=0)return false;

        int sm1=0,sm2=0;
        for(int i=0;i<=(s.length()/2)-1;i++){
            sm1+=s.charAt(i)-'0';
            sm2+=s.charAt(s.length()-i-1)-'0';

        }

        return sm1==sm2;
    }

}

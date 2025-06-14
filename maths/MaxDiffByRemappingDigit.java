package Maths;

/*
			2566. Maximum Difference by Remapping a Digit
*/

public class MaxDiffByRemappingDigit {
	
	public int minMaxDifference(int n) {

        String num=String.valueOf(n);
        int n1=9,n2=0;

        for(int i=0;i<num.length();i++){
            if(n1==9 && num.charAt(i)!='9')n1=num.charAt(i)-'0';
            if(n2==0 && num.charAt(i)!='0')n2=num.charAt(i)-'0';
        }

        int rem=0;
        int a=0,b=0,k;
        
        StringBuilder sb=new StringBuilder();
        while(n>0){
            a=n%10;
            b=n%10;
            if(a==n1)a=9;
            if(b==n2)b=0;

            k=a-b-rem;

            if(k<0){
                k=10+k;
                rem=1;
            }else{
                rem=0;
            }
            sb.append(k);
            n/=10;
        }

        return Integer.valueOf(sb.reverse().toString());

                
    }

}

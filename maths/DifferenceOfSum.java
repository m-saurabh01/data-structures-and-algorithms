package Maths;

/*
			2894. Divisible and Non-divisible Sums Difference
*/
public class DifferenceOfSum {
	
	public int differenceOfSums(int n, int m) {
 

        int sn=n*(n+1)/2;
        
        int l= n-(n%m);
        int sm=(l/m) *(m+l);
        

        return sn-sm;
    }

}

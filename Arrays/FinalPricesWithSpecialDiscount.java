package Arrays;

/*
 * 			Leetcode Easy 1475. Final Prices With a Special Discount in a Shop
 * 
You are given an integer array prices where prices[i] is the price of the ith item in a shop.

There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.

Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.

*/

public class FinalPricesWithSpecialDiscount {
	
	public int[] finalPrices(int[] arr) {
        int n=arr.length;
        int[] res=new int[n];

        for(int i=0;i<n;i++){
            res[i]=arr[i];
            for(int j=i+1;j<n;j++){
                if(arr[i]>=arr[j]){
                    res[i]-=arr[j];
                    break;
                }
            }
        }
        
        return res;
    }

}

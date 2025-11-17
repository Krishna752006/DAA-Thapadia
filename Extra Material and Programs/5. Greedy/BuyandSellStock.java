import java.util.*;
class Solution {
	public int maxProfit(int prices[]) 
	{
        int minprice = prices[0] ;
        int maxprofit = 0;
        for(int i=1;i<prices.length;i++)
		{
          	if(minprice>prices[i]) 
				minprice=prices[i];
           	maxprofit=Math.max(maxprofit,prices[i]-minprice);
        }
		//System.out.println("minprice " + minprice + " maxprofit " + maxprofit);
       	return maxprofit;
   	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String[] ar = sc.nextLine().split(" ");
        int n = ar.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) 
		{
        	arr[i] = Integer.parseInt(ar[i]);
        }
		System.out.println(new Solution().maxProfit(arr));
	}
}
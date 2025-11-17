import java.util.*;
class Main
{
	public static int findMaxProfit(int[] x, int[] y)
	{
		//WRITE YOUR CODE HERE
		int m = x.length;
		int dp[][] = new int[m][3];
		dp[0][0] = 0;
		dp[0][1] = x[0];
		dp[0][2] = y[0];
		for(int i = 1;i<m;i++)
		{
		    dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
		    dp[i][1] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2])) + x[i];
		    dp[i][2] = dp[i-1][0]+y[i];
		}
		return Math.max(dp[m-1][1],Math.max(dp[m-1][1],dp[m-1][2]));
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int m = sc.nextInt();
		int[] x = new int[m];
		int[] y = new int[m];
		for(int i=0;i<m;i++)
			x[i]=sc.nextInt();
		for(int i=0;i<m;i++)
			y[i]=sc.nextInt();
		System.out.println(findMaxProfit(x, y));
	}
}
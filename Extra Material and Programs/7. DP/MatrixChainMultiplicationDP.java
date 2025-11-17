import java.util.*;

/*
1) Iterate from len = 1 to N-1 which denotes the length of the range:
	Iterate from i = 1 to N-1en:
		Find the right end of the range (j) having l matrices.
		Iterate from k = i to j which denotes the point of partition.
			Multiply the matrices in range (i, k) and (k, j).
			This will create two matrices with dimensions arr[i-1]*arr[k] and arr[k]*arr[j].
			The number of multiplications to be performed to multiply these 
			two matrices are arr[i-1]*arr[k]*arr[j].

			The total number of multiplications is dp[i][k]+ dp[k+1][j] + arr[i-1]*arr[k]*arr[j]

2) The value stored at dp[1][N-1] is the required answer.
*/

class MatrixChainMultiplicationDP {
	// Matrix Pi has dimension p[i-1] x p[i] for i = 1..n
	static int MatrixChainOrder(int p[], int n){
		int dp[][] = new int[n][n];

		int i, j, k, len, cost;

		/* m[i, j] = Minimum number of scalar multiplications needed
		to compute the matrix P[i]P[i+1]...P[j] =P[i..j] where
		dimension of P[i] is p[i-1] x p[i] */

		// len is chain length.
		for (len = 1; len < n - 1; len++) {
			for (i = 1; i < n - len; i++) {
				j = i + len;
				dp[i][j] = Integer.MAX_VALUE;
				for (k = i; k < j; k++) {
					cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
					System.out.println("i " + i + " k " + k + " j " + j + " len " + len + " cost " + cost);
					if (cost < dp[i][j])
						dp[i][j] = cost;
				}
			}
		}
		System.out.println(Arrays.deepToString(dp));
		return dp[1][n - 1];
	}

	public static void main(String args[])
	{
		/*
		6
		4 10 3 12 20 7
		*/
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();

		System.out.println(MatrixChainOrder(arr, n));
	}
}

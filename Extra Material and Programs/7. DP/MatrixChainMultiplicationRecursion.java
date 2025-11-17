import java.util.*;

/*

1) Take the sequence of matrices and separate into two sub sequences

2) Find the minimum cost of multiplying each sub sequence

3) Add these cost together, and add in the cost of mutiplying the two result matrices

4) Do this for each position at which the sequence of matrices can be split, 
and take the minimum over all of them

Note ; We'll be given an array arr[ ] which represents the chain of matrices such that 
the ith matrix arr[i] is of dimension arr[i-1] x arr[i].

That's why we start out 'k' i.e partition from 'i' =1 so that arr[1] is of dimensions arr[1-1] * arr[1] 
else we'll get index out of bound error Eg arr[0-1] * arr[0] is not possible

So first half of the array is from i to k & other half is from k+1 to j
Also we need to find the cost of multiplication of these 2 resultant matrixes (first half & second half) 
which is nothing but 

arr[i-1] * arr[k] * arr[j]

*/

class MatrixChainMultiplicationRecursion {
	// Matrix Pi has dimension P[i-1] x P[i] for i = 1..n
	static int MatrixChainOrder(int p[], int i, int j){
		System.out.println("i " + i + " j " + j);
		if (i == j)
			return 0;

		int min = Integer.MAX_VALUE;

		// Place parenthesis at different places between first and last matrix,
		// recursively calculate count of multiplications for each parenthesis placement
		// and return the minimum count
		for (int k = i; k < j; k++) {
			// recur for `M[i+1]…M[k]` to get an `i × k` matrix
			int count = MatrixChainOrder(p, i, k);
			// recur for `M[k+1]…M[j]` to get an `k × j` matrix
			count += MatrixChainOrder(p, k + 1, j);
			// cost to multiply two `i × k` and `k × j` matrix
			count += p[i - 1] * p[k] * p[j];

			System.out.println("i " + i + " k " + k + " j " + j + " min " + min + " count " + count);
			if (count < min)
				min = count;
		}
		// Return minimum count
		return min;
	}

	public static void main(String args[]){
		/*
		5
		4 5 3 6 2
		*/
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();

		System.out.println(MatrixChainOrder(arr, 1, n - 1));
	}
}

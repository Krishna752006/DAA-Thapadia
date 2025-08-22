/*
Tree Recursion: If a recursive function calling itself for one time then it is known as Linear Recursion.
If a recursive function calling itself for more than one time then it ls known as Tree Recursion.

Time Complexity: O(2^n) 
Space Complexity: O(n)
*/

class test {
	static int count;
	// Recursion function
	static void fun(int n)
	{
		count++;
		if (n > 0) {
			System.out.print(n + " ");
	 
			fun(n - 1);	 
			fun(n - 1);
		}
	}	
 
	public static void main(String[] args)
	{
		int x = 2;
		fun(x);
		System.out.println("\nCount " + count);
	}
}
 
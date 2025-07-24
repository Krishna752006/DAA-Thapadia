/*
Head Recursion: Recursive call is the first statement in the function then it is known as Head Recursion. 
There is no statement, no operation before the call. The function does not have to process or perform any operation 
at the time of calling and all operations are done at returning time.

Time Complexity: O(n) 
Space Complexity: O(n)

Without recursion:
Time Complexity: O(n) 
Space Complexity: O(1)
*/

class test {
 
	// Recursion function
	static void fun(int n)
	{
		if (n > 0) {
	 
			// First statement in the function
			fun(n - 1);
	 
			System.out.print(n + " ");
		}
	}

	static void fun2(int n)
	{
		int i = 1;
		while (i <= n) {
			System.out.print(" "+ i);
			i++;
		}
	}
 
	public static void main(String[] args)
	{
		int x = 4;
		fun(x);
	}
}
 
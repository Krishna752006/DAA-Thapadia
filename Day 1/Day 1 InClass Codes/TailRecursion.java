/*
Tail Recursion: Recursive call is the last statement in the function. After that call the recursive function 
performs nothing. The function has to process or perform any operation at the time of calling 
and it does nothing at returning time.

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
		if (n > 0)
		{
			System.out.print(n + " ");

			// Last statement in the function
			fun(n - 1);
		}
	}

	static void fun2(int n)
	{
		while (n > 0) {
			System.out.print(n + " ");
			n--;
		}
	}
 
	public static void main(String[] args)
	{
		int x = 4;
		fun(x);
	}
}
 
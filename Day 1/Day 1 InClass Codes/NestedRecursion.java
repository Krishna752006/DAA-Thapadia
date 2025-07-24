/*
Nested Recursion: In this recursion, a recursive function will pass the parameter as a recursive call. 
That means 'recursion inside recursion'
*/

class test {
 
	// Recursion function
	static int fun(int n)
	{
		System.out.print(n + " " );
		if (n > 100)
			return n - 10;
 
		// Recursion inside the recursion
		return fun(fun(n + 11));
	}	
 //95 106 96 107 97 108 98 109 99 110 100 111 101 91
	public static void main(String[] args)
	{
		int result;
		result = fun(95);
		System.out.print(result);
	}
}
 
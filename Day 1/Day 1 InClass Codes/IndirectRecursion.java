/*
Mutual/Indirect Recursion: In this recursion, there may be more than one functions 
and they are calling one another in a circular manner.
*/

class test {
	static void funA(int n){
		if (n > 0) {
			System.out.print(n + " ");
			funB(n - 1);
		}
	}
	static void funB(int n){
		if (n > 1) {
			System.out.print(n + " ");
			funA(n / 2);
		}
	} 

	public static void main(String[] args)
	{
		funA(10);
	}
}
 
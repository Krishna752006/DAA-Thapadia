import java.util.*;
class Solution
{
    public static int fib(int a)
    {
        if(a <= 1)
        return a;
        return fib(a-1)+fib(a-2);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i < n; i++)
        {
            System.out.print(fib(i) + " ");
        }
        sc.close();
    }
}
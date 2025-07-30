import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int gcd = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int arr[] = new int[a];
        for(int i = 0;i<a;i++)
        {
            arr[i] = sc.nextInt();
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i]);
        }
        System.out.print(Gcd(min,max));
        sc.close();
    }
    public static int Gcd(int a,int b)
    {
        if(b == 0) return a;
        return gcd(b,a%b);
    }
}
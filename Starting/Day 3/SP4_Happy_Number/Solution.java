import java.util.*;
class Solution
{
    static int k;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        k = a;
        System.out.print(happy(a,1));
        sc.close();
    }
    public static boolean happy(int a,int b)
    {
        int d, s = 0;
        while(a>0)
        {
            d = a%10;
            s += d*d;
            a /= 10;
        }
        if(s == 1)
        return true;
        else if(s == k || b > 25)
        return false;
        else
        return happy(s,b+1);
    }
}
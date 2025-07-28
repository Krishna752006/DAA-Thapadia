import java.util.*;
class Solution
{
    static int result = 0;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = 0;
        find(a,b,c);
        System.out.print(result);
        sc.close();
    }
    public static void find(int a,int b,int c)
    {
        if(c > a)
        return;
        if(c == a)
        {
            result++;
            return;
        }
        for(int i = 1;i<=b;i++)
        {
            find(a,b,c+i);
        }
    }
}
import java.util.*;
class Solution
{
    static int result = 0;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 0;
        find(n,c);
        System.out.println(result);
        sc.close();
    }
    public static void find(int a,int c)
    {
        if(c > a)
        return;
        if(c == a)
        {
            result++;
            return;
        }
        find(a,c+1);
        find(a,c+2);
    }
}
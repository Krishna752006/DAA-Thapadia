import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(new String(new Solution().reverse(s.toCharArray(),0,s.length()-1)));
        sc.close();
    }
    static char[] reverse(char[] a,int s,int e)
    {
        if(s>=e)
        return a;
        char ch = a[s];
        a[s] = a[e];
        a[e] = ch;
        return reverse(a,s+1,e-1);
    }
}
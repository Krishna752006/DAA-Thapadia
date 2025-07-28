import java.util.*;
class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int arr[] = new int[a];
        for(int i = 0;i<a;i++)
        {
            arr[i]=sc.nextInt();
        }
        int c = 1;
        for(int i = 1;i<a;i++)
        {
            if(arr[i] == arr[i-1] && i < a)
            continue;
            else
            c++;
        }
        System.out.println(c);
        sc.close();
    }
}
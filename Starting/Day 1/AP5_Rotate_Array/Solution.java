import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int arr[] = new int[a];
        for(int i = 0; i < a;i++)
        {
            arr[i] = sc.nextInt();
        }
        int b = sc.nextInt();
        reverse(arr,0,a-1);
        reverse(arr,0,b-1);
        reverse(arr,b,a-1);
        for(int i : arr)
        {
            System.out.print(i + " ");
        }
        sc.close();
    }
    public static void reverse(int[] arr,int s,int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
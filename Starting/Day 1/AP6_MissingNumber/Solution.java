import java.util.Scanner;
class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int s = 0;
        int arr[] = new int[a];
        for(int i = 0; i < a;i++)
        {
            arr[i] = sc.nextInt();
            s+=arr[i];
        }
        int k = (a+1)*(a+2)/2;
        System.out.println(k-s);
        sc.close();
    }
}
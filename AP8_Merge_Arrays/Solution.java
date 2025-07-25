import java.util.*;
class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr1[] = new int[m];
        int arr2[] = new int[n];
        for(int i = 0;i < m;i++)
        {
            arr1[i] = sc.nextInt();
        }
        for(int i = 0;i < n;i++)
        {
            arr2[i] = sc.nextInt();
        }
        int i = 0, j = 0;
        while(i < m && j < n)
        {
            if(arr1[i] < arr2[j] && i < m)
            i++;
            else if(arr1[i] > arr2[j] && i < m)
            {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }     
            if(i == m || j == n)
            break;
        }
        sc.close();
    }
}
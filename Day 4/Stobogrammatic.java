import java.util.*;
class Stobogrammatic {
    static int[] arr = {0,1,-1,-1,-1,-1,9,-1,8,6};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = (int)Math.pow(10,n-1);i < Math.pow(10,n);i++)
        {
            if(!stg(i)) continue;
            System.out.print(i + " ");
        }
        sc.close();
    }
    static boolean stg(int a)
    {
        char[] ch = String.valueOf(a).toCharArray();
        int l = 0;
        int r = ch.length-1;
        while(l<=r)
        {
            int ld = ch[l] - '0';
            int rd = ch[r] - '0';
            if(arr[ld] == -1 || arr[rd] == -1) return false;
            if(arr[ld] != rd) return false;
            l++;
            r--;
        }
        return true;
    }
}
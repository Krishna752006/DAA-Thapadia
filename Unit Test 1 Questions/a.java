import java.util.*;
class a{
    public static void main(String[] args)
    {
        int N = 4;
        double P = 50;
        int arr[] = {3, 5, 8, 10};
        double low = 0;
        double max = -1.0;
        for(int i: arr)
        {
            max = Math.max(max,i);
        }
        double lt = 1-(P/100);
        for(int i = 0;i<100;i++)
        {
            double mid = low + (max-low)/2;
            double g = 0,r = 0;
            for(int j: arr)
            {
                if(j>=mid)
                g+=(j-mid);
                else
                r+=(mid-j);
            }
            if(g*lt>=r) low = mid;
            else max = mid;
        }
        System.out.printf("%.5f%n",low);
    }
}
import java.util.*;

class MinDays_To_MakeBoquet_LT1482
{
    public int minDays(int[] bloomDay, int m, int k) 
    {
        if(m*k> bloomDay.length) return -1; 
        int low = 1;
        int high = max(bloomDay);
        int ans =-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int bouquets =0;
            int flowers =0;
            for(int d : bloomDay)
            {
                if(d<=mid)
                {
                    flowers++;
                    if(flowers==k) 
                    {
                        bouquets++;
                        flowers =0;
                    }
                } 
                else flowers =0;
            }

            if(bouquets>=m){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static int max(int[] days)
    {
        int max = Integer.MIN_VALUE;
        for(int n : days){
            if(n>max) max = n;
        }
        return max;
    }
}


/* T.C = O(n*logD) , S.C = O(1) */
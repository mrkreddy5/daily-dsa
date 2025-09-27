public class Ship_Weight_LTC1011 {
    public static void main(String[] args) {
        int[] weigths = {1,2,3,1,1};
        int days = 4;
        System.out.println(shipWithinDays(weigths, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int[] bound = bounds(weights);
        int low = bound[0];
        int high = bound[1];
        int ans =0;
        while(low<=high){
            int mid = low + (high-low)/2;
            int d=1;
            int currW =0;;
            for(int w : weights){
                if(currW + w <= mid){
                    currW += w;
                }
                else{
                    // System.out.println("Weight:" + currW);
                    d++;
                    currW = w;
                }
            }

            // System.out.println(mid + ":" + d);
            if(d<=days){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static int[] bounds(int[] nums){
        int sum =0;
        int max = Integer.MIN_VALUE;
        for(int n : nums){
            sum += n;
            if(n>max) max = n;
        }
        return new int[]{max,sum};
    }
}


/* T.C = O(nlogs) , n= elements or packages , s = sum of weights */

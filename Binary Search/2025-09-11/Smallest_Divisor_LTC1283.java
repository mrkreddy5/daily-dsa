public class Smallest_Divisor_LTC1283 {
    public static void main(String[] args) {
        int[] nums = {1000000};
        int t = 2;
        System.out.println(smallestDivisor(nums,t));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = max(nums);
        int mid =0;
        int ans =0;
        while(low<=high){
            mid = low + (high-low)/2;
            int csum =0;
            for(int n : nums){
                System.out.println((n + mid -1)/mid);
                csum += (n + mid -1)/mid;
            }
            System.out.println(mid + "," + csum);

            if(csum <= threshold){
                ans = mid;
                high = mid-1;  
            }
            else{
                low = mid+1;
            }

            // System.out.println("----------------------------");
        }
        return ans;
    }

    public static int max(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int n : nums){
            if(n>max) max = n;
        }
        return max;
    }
}


/* T.C = O(n*logm), S.C = O(1) */
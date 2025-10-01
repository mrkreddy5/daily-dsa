public class Split_Array_Largest_Sum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(min_largest_sum(nums,k));
    }

    public static int min_largest_sum(int[] nums, int k){
        int[] low_high = min_max(nums);
        int low = low_high[0];
        int high = low_high[1];
        int ans = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            // System.out.println(mid + ":" + valid_sum(nums, k, mid));
            if(valid_sum(nums, k, mid)){
                // System.out.println(mid);
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static boolean valid_sum(int[] nums, int k, int mid){
        int c=1;
        int curr_sum =0;
        // System.out.println("mid :" + mid);
        for(int n: nums){
            if(n>mid) return false;
            else if(curr_sum + n <= mid){
                curr_sum += n;
            }
            else{
                // System.out.println(curr_sum + ":" + mid);
                // System.out.println("c++");
                curr_sum = n;
                c++;
                if(c>k) return false;
            }
        }
        System.out.println(c + ":" + mid);
        return true;
    }

    public static int[] min_max(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int n : nums){
            if(n>max) max = n;
            sum +=n;
        }
        return new int[]{max,sum};
    }
}

/*
    T.C = O(nlog(sum))
 */
import java.util.*;

class Max_Possible_Min_dist{
    public static void main(String[] args) {
        int[] nums = {0,3,4,7,10,9};
        int k = 4;
        System.out.println(min_dist(nums,k));
    }

    public static int min_dist(int[] nums, int k){
        Arrays.sort(nums);
        int low = 1;
        int high = nums[nums.length-1]-nums[0];
        int ans =0;
        while(low<=high){
            int mid = low + (high-low)/2;
            int c =1;
            int lastPlaced = nums[0];
            for(int i=1;i<nums.length;i++){
                if(nums[i]-lastPlaced>=mid){
                    lastPlaced = nums[i];
                    c++;
                }
            }
            System.out.println(low + ":" + mid + ":" + high + ":" + c);
            if(c>=k){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}


/*  O(nlogn + nlog(max-min)) */
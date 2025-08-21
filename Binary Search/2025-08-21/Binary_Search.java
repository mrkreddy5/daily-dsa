
public class Binary_Search {
    public int search(int[] nums, int target) {
        int low =0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low + high) >>> 1;
            if(target==nums[mid]) return mid;
            else if(target>nums[mid]) low = mid+1;
            else high=mid-1;
        }
        return -1;
    }
}

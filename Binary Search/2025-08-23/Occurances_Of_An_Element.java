public class Occurances_Of_An_Element {
    public int searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return 0;
        }
       int firstOcc = firstOccurance(nums,target, low, high);
       int lastOcc = lastOccurance(nums,target, low, high);

       if (firstOcc == -1 || lastOcc == -1) {
            return 0;
        }
       return lastOcc - firstOcc + 1;
    }

    public int firstOccurance(int[] nums,int target, int low, int high){
        int firstOcc = -1;
        int mid=0;
        while(low<=high){
            mid = low + ((high-low)>>1);
            if(target==nums[mid]){
                firstOcc = mid;
                high = mid-1;
            }
            else if(target<nums[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return firstOcc;
    }


    public int lastOccurance(int[] nums,int target, int low, int high){
        int lastOcc = -1;
        int mid=0;
        while(low<=high){
            mid = low + ((high-low)>>1);
            if(target==nums[mid]){
                lastOcc = mid;
                low = mid+1;
            }
            else if(target<nums[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return lastOcc;
    }
}

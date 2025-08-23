
public class First_Last_Occurance_Of_An_Element {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
       int firstOcc = firstOccurance(nums,target, low, high);
       int lastOcc = lastOccurance(nums,target, low, high);
       return new int[]{firstOcc, lastOcc};
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

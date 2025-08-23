public class Floor_Ceil_In_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,3};
        int target = 2;
        int[] res = floor_ceil(nums, target, 0, nums.length-1);
        System.out.println(res[0] + ", " + res[1]);
    }

    public static int[] floor_ceil(int[] nums,int target, int low, int high){
        int floor = -1, ceil =-1;
        if(target<nums[low] || target>nums[high]){
            return new int[]{floor, ceil};
        }
        int mid=0;
        while(low<=high){
            mid = low + ((high-low)>>1);
            if(target==nums[mid]){
                return new int[]{nums[mid], nums[mid]};
            }
            else if(target<nums[mid]){
                ceil = nums[mid];     // possible ceil
                high = mid-1;
            }
            else{
                floor = nums[mid];      // possible floor
                low = mid+1;
            }
        }
        return new int[]{floor, ceil};
    }
}

public class Highest_Element_Unsorted_Array {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(peakElememt(nums));
    }

    public static int peakElememt(int[] nums){
        int len = nums.length;
        if(len==1) return 0;
        else if(nums[0]>nums[1]) return 0;
        else if(len==2 && nums[0]>nums[1]) return 1;
        else if(nums[len-1]>nums[len-2]) return len-1;
        else{
            int low = 1;
            int high = nums.length-2;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                    return mid;
                }
                else if(nums[mid]<nums[mid+1]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}

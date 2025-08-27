public class Smallest_Value_In_Rotated_Array {
    public int findMin(int[] nums) 
    {
        int low = 0, high = nums.length-1;
        int mid =0;
        while(low<high){
            mid = low + (high-low)/2;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return nums[low];
    }
}


/* T.C = O(logn) , S.C = O(1) */

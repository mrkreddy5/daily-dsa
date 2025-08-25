
public class Search_In_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7};
        System.out.println(rotBS(nums, 3, 6));
    }

    public static int rotBS(int[] nums,int k, int target){
        int low=0, high=nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                return (mid + k )%nums.length;
            }
            else if(nums[mid]<target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
}

public class NoOf_Times_Array_Rotated {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2,3};
        int low = 0, high = nums.length-1;
        int mid = 0;
        while(low<high){
            mid = low + (high-low)/2;
            if(nums[mid]>nums[high]) low = mid+1;
            else high = mid;
        }
        System.out.println(low);
    }
}

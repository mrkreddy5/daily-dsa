
public class Kth_Missing_Number {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 2;
        System.out.println(kth_Missing(nums, k));
    }

    public static int kth_Missing(int[] nums, int k){
         public int findKthPositive(int[] nums, int k) {
        int l = nums.length;
        if(nums[l-1]-l<k){
            return  k+l;
        }
        else{
            int low=0;
            int high = l-1;
            while(low<high){
                int mid = low + (high-low)/2;
                if(nums[mid]-(mid+1)<k){
                    low = mid+1;
                }
                else{
                    high = mid;
                }
            }
            return  k+low;
        }
    }
}



/* Classical binary search - Finding the exact element 
    Lower bound search - Finding the min value for the given condition where mid may be a solution so we should not skip mid unlike in
    classical binary search where high goes to mid-1, here high = mid
*/

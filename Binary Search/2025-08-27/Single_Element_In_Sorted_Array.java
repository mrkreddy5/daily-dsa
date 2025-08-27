
public class Single_Element_In_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(singleNonDuplicateOptimal(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            System.out.println("low: " + low + " mid: " + mid + " high:" + high);
            if(mid!=0 && mid!=nums.length-1){
                if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                    return nums[mid];
                } 
                else if(nums[mid]==nums[mid+1]){
                    if(mid%2==0){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }
                else {                      /*if(nums[mid]==nums[mid-1]) */
                    if(mid%2!=0){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }
            }
            else 
                return nums[mid];
        }
        return 0;
    }



    /* The above code runs successfully but takes more time, the problem lies at pre boundary checks
      If the single element lies at index 0 or at last entire binary search has to be done , if we check
      edge cases before time will be saved , still both has same T.C = O(n) and same S.C = O(1)
      But the optimal way is pre checking of edge cases 
    */


    public static int singleNonDuplicateOptimal(int[] nums) {
        int len = nums.length;

        if(len==1 || nums[0]!=nums[1]) return nums[0];
        if(nums[len-2]!=nums[len-1]) return nums[len-1];

        int low = 1;
        int high = len-2;
        while(low<=high){
            int mid = low + (high-low)/2;
            // System.out.println("low: " + low + " mid: " + mid + " high:" + high);
            // if(mid!=0 && mid!=nums.length-1){
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                return nums[mid];
            } 
            else if(nums[mid]==nums[mid+1]){
                if(mid%2==0){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            else {                      /*if(nums[mid]==nums[mid-1]) */
                if(mid%2!=0){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            // }
            // else 
            //     return nums[mid];
        }
        return 0;
    }
}

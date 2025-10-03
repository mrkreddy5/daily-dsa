public class Elementary_Search_II {
    public static void main(String[] args) {
        int[][] nums = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int target = 41;
        System.out.println(validate_element_optimised(nums, target));
    }

    public static boolean validate_element(int[][] nums, int target){
        int clen = nums[0].length-1;
        for(int i=0;i<nums.length;i++){
            int low = 0;
            int high = clen;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(nums[i][mid]==target){
                    return true;
                }
                else if(nums[i][mid]>target){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
        }
        return false;
    }

    /* The above code applies binary search individually for each row leads T.C = O(nlogm) 
       The below is an optimised version using stair case approach starts from 1st row and last column
    */

    public static boolean validate_element_optimised(int[][] nums, int target){
        int row = 0;
        int col = nums[0].length-1;
        while(row<nums.length && col>=0){
            if(nums[row][col]==target){
                return true;
            }
            else if(nums[row][col]>target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
}

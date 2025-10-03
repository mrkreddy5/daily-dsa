public class Elementray_Search_In_2DArray {
    public static void main(String[] args) {
        int[][] nums = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 7;
        System.out.println(validate_element(nums, target)); 
    }

    public static boolean validate_element(int[][] nums, int target){
        int rlen = nums.length;
        int clen = nums[0].length;
        int low = 0;
        int high =  rlen * clen - 1; 
        while(low<=high){
            int mid = low + (high-low)/2;
            int row = mid/clen;
            int col = mid % clen;
            System.out.println(row + ":" + col + ":" + nums[row][col]);
            if(nums[row][col]==target){
                return true;
            }
            else if(nums[row][col]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}


/* T.C = O(log(m*n)) */

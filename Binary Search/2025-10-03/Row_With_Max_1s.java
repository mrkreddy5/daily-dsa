public class Row_With_Max_1s {
    public static void main(String[] args) {
        int[][] nums = {{0, 0, 1}, {0, 1, 1}, {0, 0, 0}};
        System.out.println(max_row_using_BS(nums));
    }

    public static int max_row(int[][] nums){
        int maxR=0;
        int maxC =0;
        for(int i=0;i<nums.length;i++){
            int c =0;
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]==1) c++;
            }
            if(c>maxC) {
                maxC = c;
                maxR = i;
            }
        }
        return maxR;
    }

    /* The above code is in O(n*m) 
       The below code is using binary search O(nlog(m))
    */

    public static int max_row_using_BS(int[][] nums){
        int maxR=0;
        int maxC =0;
        int len = nums[0].length;
        for(int i=0;i<nums.length;i++){
            int c = ones_count(nums[i], len);
            if(c>maxC) {
                maxC = c;
                maxR = i;
            }
        }
        return maxR;
    }

    public static int ones_count(int[] arr, int len){
        int low = 0;
        int high = len-1;
        int pos = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==1){
                pos = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return len-pos;
    }

    /* We can optimize the code even more using the stair case approach which give result in O(n+m) 
       We start col at last element but row from beginning as if 2 rows have same 1 frequency we have to return smaller index 
    */

    public static int max_row_optimized(int[][] nums){
        int row = 0;
        int col = nums[0].length-1;
        int maxRow = row;
        while(row<nums.length && col>=0){
            if(nums[row][col]==1){
                maxRow = row;
                col--;
            }
            else{
                row++;
            }
        }
        return maxRow;
    }
}

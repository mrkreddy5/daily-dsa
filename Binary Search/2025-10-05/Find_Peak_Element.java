public class Find_Peak_Element {
    public static void main(String[] args) {
        int[][] matrix = {
            {-1, -1, -1, -1, -1},
            {-1,  1,  4, -1, -1},
            {-1,  3,  2, -1, -1},
            {-1, -1, -1, -1, -1}
        };
        int[] res = peak_element(matrix);
        for(int i=0;i<2;i++){
            System.out.println(res[i]);
        }
    }

    /* Inner matrix is the original matrix , -1 is the imaginary circular outer matrix  
        T.C = O(n*m) for above code , T.C = O(n*logm) for below code
    */
    public static int[] peak_element(int[][] matrix){
        int rowLen = matrix.length-1;
        int colLen = matrix[0].length-1;
        for(int row=1;row<rowLen;row++){
            for(int col=1;col<colLen;col++){
                int ele = matrix[row][col]; 
                boolean up = row==1 || matrix[row-1][col]<ele;
                boolean down = row== rowLen || matrix[row+1][col]<ele;
                boolean left = col==1 || matrix[row][col-1]<ele;
                boolean right = col== colLen || matrix[row][col+1]<ele;
                if(up && down && left && right){
                    return new int[]{row-1,col-1};
                }
            }
        }
        return new int[]{0,0};
    }

    public static int[] optimised_peak(int[][] matrix){
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int low = 0;
        int high = colLen - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int maxRow = 0;
            for(int row=1;row<rowLen;row++){
                if(matrix[row][mid]>matrix[maxRow][mid]) maxRow = row;
            }

            int ele = matrix[maxRow][mid];
            int left = mid==0 ? Integer.MIN_VALUE : matrix[maxRow][mid-1];
            int right = mid==colLen-1 ? Integer.MIN_VALUE : matrix[maxRow][mid+1];
            if(left<ele && right<ele){
                return new int[]{maxRow, mid};
            }
            else if(left>ele){
                high = mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return new int[]{-1,-1};
    }
}

public class SetMatrixZeroes {
    // public static void main(String[] args) {
    //     int[][] matrix = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
    //     matrixZeroes(matrix);
    // }

    public static void matrixZeroes(int[][] nums){

        // System.out.println("Original matrix:");
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < nums[0].length; j++) {
        //         System.out.print(nums[i][j] + "   ");
        //     }
        //     System.out.println();
        // }

        boolean fc = false, fr = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i][0] == 0) fc = true;
        }

        for (int j = 0; j < nums[0].length; j++) {
            if (nums[0][j] == 0) fr = true;
        }


        for(int i=1;i<nums.length;i++){
            for(int j=1;j<nums[0].length;j++){
                if(nums[i][j]==0){
                    nums[i][0]=0;
                    nums[0][j]=0;
                }
            }
        }

        // System.out.println("Intermediate matrix:");
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < nums[0].length; j++) {
        //         System.out.print(nums[i][j] + "   ");
        //     }
        //     System.out.println();
        // }


        

        for (int i = 1; i<nums.length; i++) {
            for (int j =1;j<nums[0].length; j++) {
                if (nums[i][0] == 0 || nums[0][j] == 0) {
                    nums[i][j] = 0;
                }
            }
        }

        if (fc) {
            for (int i = 0; i < nums.length; i++) {
                nums[i][0] = 0;
            }
        }

        if (fr) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[0][j] = 0;
            }
        }

        // System.out.println("updated matrix");
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < nums[0].length; j++) {
        //         System.out.print(nums[i][j] + "   ");
        //     }
        //     System.out.println();
        // }
    }
}


/*
    T.C = O(m+n + m*n)==> O(m*n)
    S.C = O(1)
    This is the optimal approach 

    O(n^2) will be the time complexity if we use below code where as we need extra space O(m+n);

 */


 class Solutions {
    public void setZeroes(int[][] matrix) {
        boolean[] r = new boolean[matrix.length];
        boolean[] c = new boolean[matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    r[i]=true;
                    c[j]=true;
                }
            }
        }
        for(int i=0;i<r.length;i++){
            int col=0;
            if(r[i]){
                while(col<c.length){
                    matrix[i][col]=0;
                    col++;
                }
            }
        }
        for(int i=0;i<c.length;i++){
            int row=0;
            if(c[i]){
                while(row<r.length){
                    matrix[row][i]=0;
                    row++;
                }
            }
        }
    }
}
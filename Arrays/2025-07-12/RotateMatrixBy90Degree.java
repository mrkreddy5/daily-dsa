public class RotateMatrixBy90Degree {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        // System.out.println("Original matrix:");
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         System.out.print(matrix[i][j] + "   ");
        //     }
        //     System.out.println();
        // }

        rotate(matrix);

        // System.out.println("Rotated matrix:");

        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         System.out.print(matrix[i][j] + "   ");
        //     }
        //     System.out.println();
        // }
    }

    public static void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=i+1;j<c;j++){
                int m = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = m;
                
            }
        }

        // System.out.println("Transpose");
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         System.out.print(matrix[i][j] + "   ");
        //     }
        //     System.out.println();
        // }

        for(int i=0;i<r;i++){
            for(int j=0;j<c/2;j++){
                int m = matrix[i][j];
                matrix[i][j] = matrix[i][c-j-1];
                matrix[i][c-j-1] = m;
            }
         }
    }
}


/*  The above code is used to rotate matrix/ image by 90 degrees using transpose 
    T.C = O(m*n) , S.C = O(1)
    T.C = O(m*n) , S.C = O(m*n) for below process 
*/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int res[][] = new int[n][n];
        for(int c=0;c<n;c++){
            for(int r=n-1;r>=0;r--){
                res[c][n-r-1] = matrix[r][c];
            }
        }
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                matrix[r][c] = res[r][c];
            }
        }
        
    }
}

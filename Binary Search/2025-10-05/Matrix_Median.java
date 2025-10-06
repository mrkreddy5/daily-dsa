import java.util.Arrays;

public class Matrix_Median {
    public static void main(String[] args) {
        int[][] mat = {{1, 4, 6}, {2, 3, 4} ,{4, 5, 8}};
        System.out.println(median(mat));
    }

    public static int median(int[][] mat){
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int rlen = mat.length;
        int clen = mat[0].length;
        for(int i=0;i<rlen;i++){
            if(mat[i][0]<low) low = mat[i][0];
            if(mat[i][clen-1]>high) high = mat[i][clen-1];
        }

        int half = (rlen * clen + 1)/2 ;
        while(low<=high){
            int mid = low + (high-low)/2;
            // System.out.println(low + ":" + mid + ":" + high);
            if(smallerOrEqual(mat,mid) < half){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }

    public static int smallerOrEqual(int[][] mat, int m){
        int c = 0;
        int clen = mat[0].length;
        for(int i=0;i<mat.length;i++){
            if (mat[i][0] > m) continue;
            else if (mat[i][clen - 1] <= m) {
                c += clen;
                continue;
            }
            else{  
                int low = 0;
                int high = clen-1;
                while(low<=high){
                    int mid = low + (high - low) / 2;
                    if(mat[i][mid]<=m){
                        low = mid +1;
                    }
                    else{
                        high = mid -1;
                    }
                }
                c += low;
            }
            
        }
        // System.out.println(c);
        return c;
    }
}


/* T.C = O(m*log(n)*log(high-low)) S.C = O(1) 
   low can be found from column 0 and high can be found from column n
   median lies in between this low and high
   number of elements is always odd, so half elements is in left partition 
   if no.of elements less than mid<half , median has to be more than current m
   at last low is the median
*/
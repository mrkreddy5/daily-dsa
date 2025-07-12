import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiral(int[][] matrix){

        int tr = 0, br = matrix.length-1, lc = 0, rc = matrix[0].length-1;
        List<Integer> li = new ArrayList<>();

        while(tr<=br && lc<= rc){

            for(int i=lc;i<=rc;i++){
                li.add(matrix[tr][i]);
            }

            tr++;

            for(int i=tr;i<=br;i++){
                li.add(matrix[i][rc]);
            }

            rc--;

            if(tr<=br){
                for(int i=rc;i>=lc;i--){
                    li.add(matrix[br][i]);
                } 
                lc++;   
            }

            

            if(lc<=rc){
                for(int i=br;i>=tr;i++){
                    li.add(matrix[i][lc]);
                }
                br--;
            }
        }

        return li;
    }
}


/* T.C = O(m*n) , where as S.c = O(m*n) if sprial matrix order has to be returned or O(1) if just printing order is enough */
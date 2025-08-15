import java.util.*;

public class Merge_OverLapping_Intervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,12},{2,6},{8,10},{15,18}};
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        List<int[]> mergedList = new ArrayList<>();

        int[] current = intervals[0];
        
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] <= current[1]){
                current[1] = Math.max(current[1], intervals[1][1]);
            }
            else{
                mergedList.add(current);
                current = intervals[i];
            }
        }
        mergedList.add(current);
        
        for(int[] interval : mergedList){
            for(int n : interval){
                System.out.print(n+" ");
            }
            System.out.println();
        }

        /* T.C = O(n*logn) and S.C = O(n) for storing in a list */
        /* In place merging without using extra storage S.C = O(1) */

        // int idx =0;
        // for(int i=1;i<intervals.length;i++){
        //     if(intervals[i][0] <= intervals[idx][1]){
        //         intervals[idx][1] = Math.max(intervals[idx][1], intervals[1][1]);
        //     }
        //     else{
        //         idx++;
        //         intervals[idx] = intervals[i];  // if not overlapping copy that interval to the next of merged ones
        //     }
        // }

        // print from 0 to idx only 
    }
}

import java.util.*;

public class MaxElementInArray {

    // public static void main(String[] args) {
    //     int[] nums = {2,2,3,1,4,1,1,2,1};
    //     maxElement(nums);
    // }
    
    public static void maxElement(int[] nums){
        int c1= 0, c2= 0;
        Integer e1= null, e2 =0;
        
        for(int n: nums){
            if(e1!=null && n==e1) c1++;
            else if(e2!=null && n==e2) c2++;
            else if(c1==0) {
                c1 =1;
                e1 = n;
            }
            else if(c2==0){
                c2 =1;
                e2 = n;
            }
            else{
                c1--;
                c2--;
            }
        }

        int t = nums.length/3;

        int freq1 =0, freq2=0;
        // System.out.println(e1 + "," + e2);
        for(int n : nums){
            if(e1!=null && n==e1) freq1++;
            if(e1!=null && n==e2) freq2++;
        }

        // System.out.println(freq1 + "," + freq2);

        // if(freq1> t && freq2> t) return new ArrayList<>(List.of(e1,e2));
        // else if(freq1> t)  return new ArrayList<>(List.of(e1));
        // else if(freq2> t)  return new ArrayList<>(List.of(e2));
        // return null;

        if(freq1> t && freq2>t) System.out.println(e1 + "," + e2);
        else if(freq1> t ) System.out.println(e1);
        else if(freq2> t ) System.out.println(e2);

    }
}


/* The above approach is Moore's voting algorithm 
    T.C = O(n) and S.C = O(1)

    where as for hashmap approach T.C = O(n+k) and S.C = O(n)
 */

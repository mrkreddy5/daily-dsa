import java.util.*;

public class IntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3,4,6,8,12,15,19};
        int[] nums2 = {1,4,5,6,9,12,};

        List<Integer> li = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                li.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                i++;
            }
        }

        for(int n : li){
            System.out.println(n);
        }
    }
}


//  t.c = O(n + m)  , s.c = O(k)

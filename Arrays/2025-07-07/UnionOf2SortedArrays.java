package Arrays;

import java.util.HashSet;
import java.util.Set;

public class UnionOf2SortedArrays {
    public int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> st = new HashSet<>();
        int i=0;
        int j =0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                st.add(nums1[i]);
                i++;
            }
            else{
                st.add(nums2[j]);
                j++;
            }
        }
       
        while(j<nums2.length){
            st.add(nums2[j]);
            j++;
        }
                
        while(i<nums1.length){
            st.add(nums1[i]);
            i++;
        }

        int[] resArr = new int[st.size()];
        i=0;
        for(int n : st){
            resArr[i++] = n;
        }

        return resArr;
    }
}


// t.c = O(n+m)

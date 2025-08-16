public class Merge_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] nums1 = {0,2,4,6,7,10,0,0,0,0,0};
        int[] nums2 = {1,3,5,8,9};
        merge(nums1, nums2);
        for(int n : nums1){
            System.out.print(n + " ");
        }

    }

    public static void merge(int[] nums1, int[] nums2){
        int l2 = nums2.length-1;
        int end = nums1.length-1;
        int l1 = end - l2 - 1;
        while(l1>=0 && l2>=0){
            if(nums1[l1]>nums2[l2]) nums1[end--]=nums1[l1--];
            else nums1[end--]= nums2[l2--];
        }
        while(l2>=0){
            nums1[end--]= nums2[l2--];
        }
        while(l1>=0){
            nums1[end--]= nums1[l1--];
        }
    }
}


/* O(m+n) is T.C and O(1) is S.C */
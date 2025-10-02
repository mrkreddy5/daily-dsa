public class Median_Of_2_Sorted_Arrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(median2(nums1,nums2));
    }

    public static double median(int[] nums1, int[] nums2){
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] nums3 = new int[l1 + l2];
        int i=0, j=0, k=0;
        while(i<l1 && j<l2){
            if(nums1[i]<nums2[j]){
                nums3[k++] = nums1[i++];
            }
            else{
                nums3[k++] = nums2[j++];
            }
        }
        while(i<l1){
            nums3[k++] = nums1[i++];
        }
        while(j<l2){
            nums3[k++] = nums2[j++];
        }
        int l3 = nums3.length;
        double res = 0f;
        if(l3%2==0){
            res = (nums3[(l3/2)-1] + nums3[l3/2])/2.0;
            System.out.println(nums3[(l3/2)-1] + ":" + nums3[l3/2]);
        }
        else{
            res = nums3[l3/2];
        }
        return res;
    }

    /* The above code is used to find medain using merge sort O(m+n) and using additional array S.C = O(m+n) 
       Below code is O(m+n) it is traversing up to half only still T.C is O(m+n) but we are not using any additional space so S.C = O(1)
    */

    public static double median1(int[] nums1, int[] nums2){
       int l1 = nums1.length;
        int l2 = nums2.length;
        int total = l1 + l2;

        int i = 0, j = 0;
        int prev = 0, curr = 0;

        for (int k = 0; k <= total / 2; k++) {
            prev = curr;
            if (i < l1 && (j >= l2 || nums1[i] <= nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
        }

        if (total % 2 == 0) {
            return (prev + curr) / 2.0; 
        } else {
            return curr; 
        }
    }

    /*
        The below code is used to find median of 2 sorted arrays in O(log(min(m,n)))
        Here we divide the entire combined array into 2 parts, for that we consider shorter length array to reduce time
        each partition has half elements , if m elements are from array1 in that left half then half-m elements are from array2
        the left end is l1 , the next element is r1 for array1 similarly for array2
        left partition may contain max len(array1) elements so low = 0 and high = len(arr1)
        the 2 conditions are l1<=r2 and l2<=r1 
        if l1>r2 then left end of arr1 is more so high has to be reduced high=mid-1;
        if l2>r1 this from arr2 so to reduce this elements from arr1 in left part should increase so low = mid+1;

        mid tells us number of elements from smaller array , not index
        half is calculated as (len1 + len2 + 1)/2  which covers merged array of both even and odd lengths 

    */

    public static double median2(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1>len2){
            return median2(nums2, nums1);
        }
        int half = (len1+len2+1)/2;
        int low = 0;
        int high = len1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int pos1 = mid;
            int pos2 = half-mid;
            int l1 = pos1-1<0 ? Integer.MIN_VALUE :nums1[pos1-1];
            int r1 = pos1>=len1 ? Integer.MAX_VALUE :nums1[pos1];
            int l2 = pos2-1<0 ? Integer.MIN_VALUE :nums2[pos2-1];
            int r2 = pos2>=len2 ? Integer.MAX_VALUE :nums2[pos2];
            if(l1<=r2 && l2<=r1){
                if((len1+len2)%2==0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.max(l1,l2)/1.0;
                }
            }
            else if(l1>r2){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return 0.0;
    }
}

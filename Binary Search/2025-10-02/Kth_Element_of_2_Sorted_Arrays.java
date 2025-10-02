public class Kth_Element_of_2_Sorted_Arrays {
    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k =5;
        System.out.println(kth_Element(a,b,k));
    }

    public static int kth_Element(int[] a, int[] b, int k){
        int res =0;
        int l1 = a.length ,l2 = b.length;
        int al=0, bl=0;
        for(int i=0;i<k;i++){
            if(al<l1 && (bl>=l2 || a[al]<b[bl])){
                res = a[al++];
            }
            else{
                res = b[bl++];
            }
        }
        return res;
    }

    public static int kth_Element_binary_search(int[] a, int[] b, int k){
        int len1 = a.length;
        int len2 = b.length;
        if(len1>len2){
            return kth_Element_binary_search(b,a,k);
        }
        int low = Math.max(0,k-len2);   // here k-len2 suggests max element limit (len2) we can take from array2,  cutA(mid) >= k-len2 ,cutB = k-cutA
        int high = Math.min(k,len1);    // we are taking min(k,len1) max we can take len1 elements if k<len1 it is better to take k only
        while(low<=high){
            int mid = low + (high-low)/2;
            int pos1 = mid;
            int pos2 = k-mid;

            int l1 = pos1-1<0 ? Integer.MIN_VALUE : a[pos1-1];
            int r1 = pos1>=len1 ? Integer.MAX_VALUE : a[pos1];
            int l2 = pos2-1<0 ? Integer.MIN_VALUE : b[pos2-1];
            int r2 = pos2>=len2 ? Integer.MAX_VALUE : b[pos2];

            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}

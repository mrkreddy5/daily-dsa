public class Max_Subarray_Product {
    public static void main(String[] args) {
        int[] nums = {-4,5,2,7,1,0,12,8};
        System.out.println(product(nums));
    }

    public static int product(int[] nums){
        int lpro = 1;
        int rpro = 1;
        int maxPro = Integer.MIN_VALUE;;
        int l = nums.length-1;
        for(int i=0;i<=l;i++){
            lpro = lpro*nums[i];
            rpro = rpro*nums[l-i];
            maxPro = Math.max(maxPro, Math.max(lpro, rpro));
            lpro = lpro==0?1:lpro;
            rpro = rpro==0?1:rpro;
        }
        return maxPro;
    }
}


// t.c = O(n) , s.c = O(1)

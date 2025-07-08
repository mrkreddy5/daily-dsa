public class LongestSubArrayWithSumK {
    public int longestSubarray(int[] nums, int k) {
       int res =0;
       int sum =0;
       int ind =0;
       for(int i=0;i<nums.length;i++){
        sum += nums[i];
        if(sum==k) res = Math.max(res,i-ind +1);
        while(sum>k){
            sum -= nums[ind++];
        }
       }
       return res;
    }
}


/* t.c = O(n), s.c = O(1) */
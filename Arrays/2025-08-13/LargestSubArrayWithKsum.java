import java.util.*;

public class LargestSubArrayWithKsum {
    public static void main(String[] args) {
        int arr[] = {10,5,7,-2,1,4,5,-1,-3};
        System.out.println(largestSubarray(arr, 15));
    }

    public static int largestSubarray(int[] nums,int k){
        Map<Integer,Integer> prefixSum = new HashMap<>();
        int maxLen = 0;
        int currentSum =0;
        for(int i=0;i<nums.length;i++){
            currentSum+= nums[i];

            if(currentSum==k) maxLen= i+1;
            if(prefixSum.containsKey(currentSum-k)){
                maxLen = Math.max(maxLen, i- prefixSum.get(currentSum-k));
            }

            prefixSum.putIfAbsent(currentSum, i);
        }
    return maxLen;
    }
}


/* t.c = O(n) and s.c = O(n) */
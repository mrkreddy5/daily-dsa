
public class Longest_Subarray_Of1_After_Deleting_One_Element {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,0,1,1};
        int maxLen = 0;
        int currentLen = 0;
        int prevFreq = 0;
        boolean zeroFound = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroFound = true;
            }
            else if(nums[i]==0 && zeroFound){
                currentLen = prevFreq;
                prevFreq = 0;
            }
            else{
                if(zeroFound) prevFreq++;
                currentLen++;
                maxLen = Math.max(maxLen,currentLen);
            }

        }

        System.out.println(!zeroFound?maxLen-1:maxLen);
    }

    /* The above approach is not preferable, compared to below both has same T.C = O(n) ans S.C = O(1) 
        but sliding window approach is more robust compared to abive approach
    */

    public static int longestSubArray(int[] nums){
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0) zeroCount++;
            while(zeroCount>1){
                if (nums[left]==0) zeroCount--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left);
        }
        return maxLen;
    }
}

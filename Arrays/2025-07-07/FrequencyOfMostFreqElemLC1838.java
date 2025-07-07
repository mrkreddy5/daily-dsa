package Arrays;

import java.util.Arrays;

public class FrequencyOfMostFreqElemLC1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long tot = 0;
        int l = 0;
        int h =0;
        for(int r=0;r<nums.length;r++){
            tot += nums[r];
            while((long)nums[r]*(r-l+1)-tot>k){
                tot -= nums[l];
                l++;
            }
            h = Math.max(h, r-l+1);
        }
        return h;
    }
}


// num * sliding window size - (current nums sum) = req operations (+)
/* 
t.c = sorting - O(nlogn)  , O(n) - for traversal

Every element is added to the window once (r)
Every element is removed from the window at most once (l++ inside the while)

This means: The total number of steps taken by l and r combined is at most 2n
*/  

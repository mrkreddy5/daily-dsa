import java.util.*;

public class LeadersInAnArray {
    public void leaders(int[] nums){
        int currMax = Integer.MIN_VALUE;
        List<Integer> li = new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>currMax){
                currMax = nums[i];
                li.add(nums[i]);
            }
        }

        Collections.reverse(li);
    }
}


/*
    Leader : An element in an array is a leader if every element on its left is less than that
    T.C = O(n + k) =O(n) , k is  for reversing
    S.C = O(k)
 */
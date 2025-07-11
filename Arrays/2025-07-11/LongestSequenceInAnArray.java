import java.util.*;

public class LongestSequenceInAnArray {
    public int longestConsecutiveUsingHashSet(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int n : nums){
            hs.add(n);
        }
        int currCount = 0;
        int maxCount =0;
        for(int h : hs){
            if(!hs.contains(h-1)){
                currCount = 1;
                int i=1;
                while(hs.contains(h+i)){
                    currCount +=1;
                    i++;
                }
                maxCount = Math.max(maxCount , currCount);
            }
        }
        return maxCount;
    }

    /*
        Both 1 and 3rd method are same codes wheres as time complexity for above code is different due to 
        data structure which is used here, time complexity for contains method in hashset is O(1)
        where as O(n) in list in worst case total time complexity is 
        T.C = O(n) for hashset
        T.C = O(nlogn) i.e is due to sorting
        T.C = O(n^2) for using list in worst case
        S.C = O(n) for both the hashset and list , O(1) is for sorting approach


    */


    public int longestConsecutiveUsingSort(int[] nums) {
        Arrays.sort(nums);
        int currCount = 1;
        int maxCount = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
            else if(nums[i]==nums[i-1]+1){
                currCount++;
            }
            else{
                currCount =1;
            }

            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }



    public int longestConsecutiveUsingList(int[] nums) {
        List<Integer> li = new ArrayList<>();
        for(int n : nums){
            li.add(n);
        }
        int currCount = 0;
        int maxCount =0;
        for(int n : li){
            if(!li.contains(n-1)){
                currCount = 1;
                int i=1;
                while(li.contains(n+i)){
                    currCount +=1;
                    i++;
                }
                maxCount = Math.max(maxCount , currCount);
            }
        }
        return maxCount;
    }


}

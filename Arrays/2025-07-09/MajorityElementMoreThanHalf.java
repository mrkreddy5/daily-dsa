import java.util.*;

class MajorityElementMoreThanHalf {
    public void majorityElement(int[] nums){
        int c =0;
        int ele = 0;
        for(int i=0;i<nums.length;i++){
            if(c==0){
                ele = nums[i];
                c = 1;
            } 
            else if(nums[i]==ele) c++;
            else c--;
        }
        
        // verification has to be made at some cases the above code might gets failed like [1,2,3,4,5]
        
        int count = 0;
        for (int num : nums) {
            if (num == ele) count++;
        }

        if (count > nums.length / 2) {
            System.out.println(ele);
        } else {
            System.out.println(-1); 
        }

       
    }

/* The above used algorithm is "Boyer-Moore Voting Algorithm" 
    T.C = O(n), s.c = O(1)

    Below one is using hashing
    T.C = O(2N)= O(n) , s.c = O(1)
 */

    public void usingHashing(int[] nums){
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int n: nums){
            mp.put(n, mp.getOrDefault(n, 0)+1);
        }

        int l = (nums.length)/2;
        for(int n : mp.keySet()){
            if(mp.get(n)>l) System.out.println(n);
        }
    }
}






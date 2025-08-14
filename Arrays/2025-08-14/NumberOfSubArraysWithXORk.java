import java.util.*;

class NumberOfSubArraysWithXORk {

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 5, 6};
        int k = 6;
        System.out.println(subarraysXOR(nums, k));
    }
    public static int subarraysXOR(int[] nums, int k){
        Map<Integer, Integer> prefixXor = new HashMap<>();
        prefixXor.put(0,1);
        int currentXor = 0;
        int total =0;
        for(int i=0;i<nums.length;i++){
            currentXor ^= nums[i];
            if(prefixXor.containsKey(currentXor^k)){
                total += prefixXor.get(currentXor^k);
            }

            prefixXor.put(currentXor, prefixXor.getOrDefault(currentXor,0)+1);
        }
        return total;
    }
}

/* O(n) is the T>C and S.C= O(n) */
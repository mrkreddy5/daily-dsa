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

/* O(n) is the T>C and S.C= O(n) 
    if xor from i(0) to j(6) = px , i to k(3) = x and l(4) to j = k 
    then px = x^k 
    apply xor on both sides with k ===> px^k = (x^k)^k = x
    so x = px^k

    if longest subarray is required then we will store index of the current xor at its first apperance using
    putIfAbsent() if count of subarrays is required then we will use a separate variable to store count and
    update frequency of that current XOR
*/
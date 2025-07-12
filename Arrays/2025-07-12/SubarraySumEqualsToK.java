import java.util.*;

public class SubarraySumEqualsToK {

    public void subArray(int[] nums, int k){
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int sum = 0;
        int res =0;
        for(int n : nums){
            sum +=n;
            int req = sum-k;
            if(mp.containsKey(req)){
                res += mp.get(req);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        System.out.println(res);
    }

    /* We are storing the prefix sum using hashpmap T.C = O(n) and S.C = O(n) 
       To print the sub arrays which sum gives k , then we store the indices using a list 

    computeIfAbsent() method:

    Behavior when key is already present:
        If the key exists in the map and its associated value is not null, computeIfAbsent() does nothing.

        It simply returns the existing value, The lambda function is not called.

    Behavior when key is present but value is null:
        If the key exists but its value is explicitly set to null , The lambda does get called.

        The map updates the key with the returned value.
    */

    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 1, 3, 3, 1, -4, -2, -2, 1, 5};
        int k = 7;
        printSubArrays(nums, k);
    }

    public static void printSubArrays(int[] nums, int k){
        Map<Integer, List<Integer>> mp = new HashMap<>();
        mp.put(0, new ArrayList<>(List.of(-1)));
        int sum =0;
        int req =0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            req = sum -k;
            if(mp.containsKey(req)){
                for(int stIndex : mp.get(req)){
                    for(int s = stIndex+1;s<=i;s++){
                        System.out.print(nums[s] + ", ");
                    }
                    System.out.println();
                }
            }
            mp.computeIfAbsent(sum, x -> new ArrayList<>()).add(i);
        }
    } 
}





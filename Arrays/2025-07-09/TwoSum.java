import java.util.*;

class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 5, 3, 8, 11, 9, 7};
        int k = 14;
        int[] result = twoSum(nums, k);
        if (result[0] != -1) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found.");
        }
    }

    public static int[] twoSum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int r = k - nums[i];
            if (mp.containsKey(r)) {
                return new int[]{mp.get(r), i};
            }
            mp.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }



    public static int[] twoSumSorted(int[] nums, int k) {
        int[][] arr = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i; 
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = arr[i][0] + arr[j][0];
            if (sum < k) i++;
            else if (sum > k) j--;
            else return new int[]{arr[i][1], arr[j][1]}; 
        }

        return new int[]{-1, -1};
    }

}



/*
hashmap approach is best one at any time compared on time complexity , if they are sorted even hashmap
approach is best , 2 pointer approach is better when indices are not important just retur yes or no
for hashmap approach t.c = O(n) , s.c = O(n)
for 2 pointer approach t.c = O(nlogn) sorting + O(n) = O(nlogn) , s.c = O(n) for unsorted input 
   case 2 : t.c = O(n) , s.c = O(1) for sorted input
 */


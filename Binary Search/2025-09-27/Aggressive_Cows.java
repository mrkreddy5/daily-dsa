import java.util.*;

class Aggressive_Cows {
    public static void main(String[] args) {
        int[] nums = {0, 3, 4, 7, 10, 9};
        int k = 4;
        System.out.println(min_dist(nums, k));
    }

    public static int min_dist(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 1; 
        int high = nums[nums.length - 1] - nums[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 1; 
            int lastPlaced = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - lastPlaced >= mid) {
                    count++;
                    lastPlaced = nums[i];
                }
            }

            System.out.println(low + ":" + mid + ":" + high + ":" + count);

            if (count >= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}

/*
   given array is unsorted , so we have to sort it fast
   according to prob statement there are k aggressive cows
   and the given arr contains locations where cows can drink water
   the aggressive cows should minimum among maximum possibility
   Input: n = 6, k = 4, nums = [0, 3, 4, 7, 10, 9]

    Output: 3

    Explanation: The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions [0, 3, 7, 10]. 
    Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways

    T.C = O(nlog(max-min))
 */
import java.util.*;

public class ThreeSum {

    // public static void main(String[] args) {
    //     int[] nums = {2,1,3,-1,-2,0,4};
    //     threeSumUsingPointers(nums);
    // }

    public static void threeSum(int[] nums){

        Set<List<Integer>> res = new HashSet<>();

        for(int i=0;i<nums.length-1;i++){

            Set<Integer> st = new HashSet<>();
            for(int j=i+1;j<nums.length;j++){

                int k = -(nums[i] + nums[j]);

                if(st.contains(k)){
                    List<Integer> li = new ArrayList<>(List.of(nums[i],nums[j],k));
                    Collections.sort(li);
                    res.add(li);
                }

                st.add(nums[j]);
            }
        }

        for(List<Integer> list : res){
            for(int l : list){
                System.out.print(l + "," );
            }
            System.out.println();
        }
    }

    /* T.C = O(n^2)  and S.C = O(n^2) as using set(list) on worst case where as using two pointers approach 
        T.C = O(n^2) but s.c = O(k) , requires sorting which is O(logn) as overhead
        On a comparision 2 pointer approach is faster and more reliable 
    */


    public static void threeSumUsingPointers(int[] nums){

        Arrays.sort(nums);
       Set<List<Integer>> res = new HashSet<>();

        for(int i=0;i<nums.length-2;i++){
            int j = i+1, k= nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;

                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
                else if(sum>0) k--;
                else j++;
            }
        }

        for(List<Integer> list : res){
            System.out.println(list);
        }

    }
}



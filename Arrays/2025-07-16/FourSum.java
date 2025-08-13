import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        int[] nums = {-3,2,4,-1,0,5,-2,-1,1,4};
        fourSumOptimised(nums);
    }

    public static void fourSum(int[] nums){

        Arrays.sort(nums);
        int len = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        for(int i=0;i<len-3;i++){

            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<len-2;j++){

                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1, l = len-1;

                while(k<l){
                    long sum = nums[i]+nums[j]+nums[k]+nums[l];

                    if(sum==0){
                        
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k<l && nums[k]==nums[k-1]) {
                            k++;
                        }

                        while (l>k && nums[l]==nums[l+1]) {
                            l--;
                        }
                    }

                    else if(sum<0){
                        k++;
                    }

                    else{
                        l--;
                    }

                }
            }
        }

        for(List<Integer> list : res){
            System.out.println(list);
        }
    }


    /*
        T.C = O(n^3) for both codes and O(nlogn) for sorting 
        where S.C = O(n^2) for above code for using hashset , where as S.C = O(k) for the below one
        On comparision below code is more optimised due to early pruning
        In hashset approach every thing is stored and duplicates are removed after that
        where as in below approach duplicates are removed earlier using pruning
    */


    public static void fourSumOptimised(int[] nums){

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<len-3;i++){

            if(i>0 && nums[i]==nums[i-1]) continue;
            if((long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>0) break;
            if((long)nums[i]+nums[len-1]+nums[len-2]+nums[len-3]<0) continue;

            
            for(int j=i+1;j<len-2;j++){

                if(j>i+1 && nums[j]==nums[j-1]) continue;
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>0) break;
                if(nums[i]+nums[j]+nums[len-1]+nums[len-2]<0) continue;

                int k=j+1, l = len-1;

                while(k<l){
                    long sum = nums[i]+nums[j]+nums[k]+nums[l];

                    if(sum==0){
                        
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k<l && nums[k]==nums[k-1]) {
                            k++;
                        }

                        while (l>k && nums[l]==nums[l+1]) {
                            l--;
                        }
                    }

                    else if(sum<0){
                        k++;
                    }

                    else{
                        l--;
                    }

                }
            }
        }

        for(List<Integer> list : res){
            System.out.println(list);
        }
    }
}

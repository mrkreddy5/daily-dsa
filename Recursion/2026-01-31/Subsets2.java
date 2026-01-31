class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        recursive(0,nums,new ArrayList<>(), res);
        return res;
    }

    public void recursive(int s,int[] nums,List<Integer> curr, List<List<Integer>> res){

       res.add(new ArrayList<>(curr));
       for(int i=s;i<nums.length;i++){
            if(i>s && nums[i]==nums[i-1]){
                continue;
            }
            curr.add(nums[i]);        
            recursive(i+1,nums,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}


// code is asymptomatically optimised , we can still optimise the recursive calls
// T.C = O(n. 2^n). => nlogn for sorting + 2^n subaets each one requires n for copying arrList from curr to res
// so n.2^n is dominating nlogn ,so final T.C = O(n.2^n)
// S.C = O(n)

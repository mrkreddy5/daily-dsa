class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        sequence(0,nums,new ArrayList<>(),res);

        return res;
    }

    public void sequence(int i, int[] nums, List<Integer> curr, List<List<Integer>> res){
        
        if(i==nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        sequence(i+1,nums,curr,res);
        curr.remove(curr.size()-1);
        sequence(i+1,nums,curr,res);
    }
}


// Every subset has length of <=n , and totally we have 2^n subsets . So total time complexity is O(n.2^n)
// similarly we store 2^n subsets each of <=n size, total S.C = O(n.2^n)

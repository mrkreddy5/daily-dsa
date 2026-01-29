class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates );
        backtrack(0,candidates, target, new ArrayList<>(), res);

        return res;
    }

    public void backtrack(int i, int[] cand, int rem, List<Integer> curr, List<List<Integer>> res){

    if(rem==0){
            res.add(new ArrayList<>(curr));
    } 
        
    for(int s=i;s<cand.length;s++ ){
        if(cand[s]>rem) break;
        if(s>i && cand[s]==cand[s-1]) continue;
        
        curr.add(cand[s]);
        backtrack(s+1,cand,rem-cand[s], curr, res);

        curr.remove(curr.size()-1);
        }
    }
}

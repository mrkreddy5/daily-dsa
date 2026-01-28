class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        makeComb(candidates,0,target,0,new ArrayList<>(),res);
        return res;
    }
    
    public void makeComb(int[] cand, int ind, int targ, int tot, List<Integer> currComb ,List<List<Integer>> res){
        if(tot == targ){
            res.add(new ArrayList<>(currComb));
            return;
        }
        if(tot >targ || ind>=cand.length){
            return;
        }
        
        currComb.add(cand[ind]);
        makeComb(cand,ind,targ,tot+cand[ind],currComb,res);
        
        currComb.remove(currComb.size()-1);
        makeComb(cand,ind+1,targ, tot,currComb,res);
    }
}


// Total subsets 2^n , each of <=n size so total T.C = O(n.2^n)
// Space.Com = O(n) ( recursion stack O(n) and Current list is O(n) => 2.O(n)=O(n)

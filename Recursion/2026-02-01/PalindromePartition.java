class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        ss(0,s,new ArrayList<>(), res);
        return res;
    }

    public void ss(int ind,String s,List<String> curr, List<List<String>> res){
        if(ind == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=ind;i<s.length();i++){
            if(isP(s,ind,i)){
                curr.add(s.substring(ind,i+1));
                ss(i+1, s, curr, res);
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isP(String s, int st,int en){
        while(st<=en){
            if(s.charAt(st)!=s.charAt(en)) {
                return false;
            }
            st++;
            en--;
        }
        return true;
    }
}


// total Time Comp= O(n. 2^n) , S.C = O(n)

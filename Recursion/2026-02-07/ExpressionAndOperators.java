class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        solve(0, num, target, 0, 0,"", res);
        return res;
    }

    public void solve(int ind, String num, int target, long value, long prev, String exp, List<String> res){

        if(ind == num.length()){
            if(value == target) 
                res.add(exp);
            return;
        }

        for(int i = ind;i<num.length();i++){
            
            if(i>ind && num.charAt(ind)=='0') break;
            
            long curr = Long.parseLong(num.substring(ind, i+1));

            if(ind==0){
                solve(i+1, num, target , curr, curr, "" + curr, res);
            }
            else{
                solve(i+1, num, target, value + curr, curr, exp + "+" + curr, res);

                solve(i+1, num, target, value - curr, -curr, exp + "-" + curr, res);

                solve(i+1, num, target, value - prev + (prev*curr), prev * curr, exp + "*" + curr, res);
            }
        }
    }
}


// 0-n-1 , each has 3 ways => 3^n
// substring at worst case n , so total Time Complexity = O(n. 3^n)
// Space complexity= O(n)

class Solution {

    private static final String[] MAP = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        recursive(0,digits, new StringBuilder(), res);
        return res;
    }

    public void recursive(int n, String digits, StringBuilder curr, List<String> res){

        if(n==digits.length()){
            res.add(curr.toString());
            return;
        }

        String letters = MAP[digits.charAt(n) -'0'];
        for(int i=0;i<letters.length();i++){
            curr.append(letters.charAt(i));
            recursive(n+1, digits, curr, res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}



// Time Complexity = at most we have 4 characters per a single digit ,
//so we have 4^n combinations, for each combination we build a string of length n
// so total = O(n.4^n) , s.c = O(n)

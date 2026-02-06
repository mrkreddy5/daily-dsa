class Solution {
    
    static Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        return combinations(0, s, wordDict);
    }

    public boolean combinations(int en, String s, List<String> wordDict){

        if(en == s.length()){
            return true;
        }

        if(memo[en]!=null) return memo[en];

        for(int i=en;i<s.length();i++){
            if(wordDict.contains(s.substring(en, i+1))){
                if(combinations(i+1, s, wordDict)){
                    return memo[en] = true;
                }
            }
        }

        return memo[en] = false;
    }
}

// en takes values from 0 to n-1
// inner loop runs from en-1 to n ==> O(n)
// substring takes O(n)

// total time complexity is O(n^3)

// space comp = O(n) 

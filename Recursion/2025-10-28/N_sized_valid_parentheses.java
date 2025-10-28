import java.util.*;
public class N_sized_valid_parentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> parenthesesList = new ArrayList<>();
        // parentheses_generate(n, "", parenthesesList);
        parentheses_generate_optimised(n, 0, 0, "", parenthesesList);
        System.out.println(parenthesesList);
    }

    public static void parentheses_generate(int n, String curr, List<String> res){
        if(curr.length()== 2*n){
            if(valid_parentheses(curr)) res.add(curr);
            return;
        }

        parentheses_generate(n, curr + '(', res);
        parentheses_generate(n, curr + ')', res);
    }

    public static boolean valid_parentheses(String curr){
        Stack<Character> st = new Stack<>();
        for(char c : curr.toCharArray()){
            if(c == '('){
                st.push(c);
            }
            else if(c == ')'){
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }

    // The above code generates every combination even it is not a valid one and validation is overhead for them
    // whereas in below code only valid ones are generated
    
    public static void parentheses_generate_optimised(int n,int open, int close,  String curr, List<String> res){
        if(curr.length() == 2*n){
            res.add(curr);
            return;
        }

        if(open<n) parentheses_generate_optimised(n, open+1, close, curr + '(', res);
        if(close<open) parentheses_generate_optimised(n, open, close+1, curr + ')', res);
    }

}

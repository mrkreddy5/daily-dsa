import java.util.*;

public class Remove_Outer_Parentheses {
    public static void main(String[] args) {
        String input = "(()())(())";
        System.out.println(res_string_optimized(input));
    }

    public static String res_string(String input){
        StringBuilder output = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : input.toCharArray()){
            if(c=='('){
                if(!stack.isEmpty()){
                    output.append(c);
                }
                stack.push(c);
            }
            else{
                stack.pop();
                if(!stack.isEmpty()){
                    output.append(c);
                }
            }
        }
        return output.toString();
    }

    /* T.C = O(n) , S.C = O(n) for above code and overhead of push and pop operations
        Below code is optimised one with T.C = O(n) and S.C = O(1) using counter approach 
    */

    public static String res_string_optimized(String input){
        StringBuilder output = new StringBuilder();
        int count = 0;
        for(char c : input.toCharArray()){
            if(c=='('){
                if(count>0) output.append(c);
                count++;
            }
            else{
                count--;
                if(count>0) output.append(c);
            }
        }
        return output.toString();
    }
}

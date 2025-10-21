import java.util.*;

public class reverse_stack {

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()) return;

        int top = stack.pop();

        reverseStack(stack);

        insertElementAtBottom(stack, top);
    }

    public static void insertElementAtBottom(Stack<Integer> stack, int ele){
        if(stack.isEmpty()){
            stack.push(ele);
            return;
        }

        int top = stack.pop();

        insertElementAtBottom(stack, ele);

        stack.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        reverseStack(stack);

        System.out.println(stack);
    }
}

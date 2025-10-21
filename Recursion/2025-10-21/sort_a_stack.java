import java.util.*;

class sort_a_stack{

    public static void sortStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        int top = stack.pop();

        sortStack(stack);

        /* removing the top element until stack contains single element, a single element is automatically sorted in a stack */
        /* now the last removed element and stack which contains single element is passed to this function */

        insertElementAtPosition(stack,top);
    }

    public static void insertElementAtPosition(Stack<Integer> stack, int ele){
        if(stack.isEmpty() || stack.peek()<ele){
            stack.push(ele);
            return;
        }

        int top = stack.pop();

        insertElementAtPosition(stack, ele);

        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        sortStack(stack);

        System.out.println(stack);
    }
}


/* [4,1,3,2] bottom to top 
    [4,1,3] , top = 2
    [4,1] , top = 3
    [4], top = 1

    now [4], ele =1 => 4<=1 (fails) so , 4(top) is removed from stack and empty stack along with eleement is passed to it
    now stack is empty so element(1) is pushed into stack and (top=4) is again pushed onto stack now stack = [1,4]

    now stack = [1,4] , ele = 3 => 4<=3 (fails) similarly 4 is removed and stack is passed along with 3 then 4 is pushed again
    now stack = [1,3,4], ele = 2 => sly 4 then 3 are removed then 2 is inserted, then 3,4 are inserted in same order

    T.C = O(n^2) for each removal and insertion 
    S.C = O(n) for stack
 */
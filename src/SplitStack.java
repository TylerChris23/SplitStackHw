import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class SplitStack {

    public static void splitStack(Stack<Integer> stack) {
        Queue<Integer> que = new LinkedList<>();
        Stack<Integer> tStack = new Stack<>();

        // Push negative numbers to tempStack in reverse order
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (num < 0) {
                tStack.push(num);
            } else {
                // If non-negative, enqueue to the queue
                que.add(num);
            }
        }

        // Push negative numbers back to stack in original order
        while (!tStack.isEmpty()) {
            stack.push(tStack.pop());
        }

        // Push non-negative numbers to the back of the stack in original order
        while (!que.isEmpty()) {
            stack.push(que.remove());
        }
    }
    public static void main(String[] args) {
        // Test cases
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(5);
        stack1.push(-5);
        stack1.push(67);
        stack1.push(-45);
        stack1.push(67);
        stack1.push(9);
        stack1.push(0);
        stack1.push(-42);
        stack1.push(56);
        stack1.push(-7);
        System.out.println("Original First Stack: " + stack1);
        splitStack(stack1);
        System.out.println("After First Stack: " + stack1);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(-2);
        stack2.push(-3);
        stack2.push(4);
        stack2.push(-5);
        stack2.push(6);
        stack2.push(-7);
        stack2.push(8);
        stack2.push(9);
        System.out.println("Original Second Stack : " + stack2);
        splitStack(stack2);
        System.out.println("After Second Stack : " + stack2);
    }
}



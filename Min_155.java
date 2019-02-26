import java.util.*;

public class Min_155 {
    // Most voted solution using one stack

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;

    public Min_155(){
        stack = new Stack<>();
    }

    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if (x <= min){          
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if (stack.pop() == min) min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }



    // Second voted solution uses only one stack
    // https://leetcode.com/problems/min-stack/discuss/49031/Share-my-Java-solution-with-ONLY-ONE-stack
    /*
    long min;
    Stack<Long> stack;

    public MinStack(){
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);//Could be negative if min value needs to change
            if (x < min) min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        
        long pop = stack.pop();
        
        if (pop < 0)  min = min - pop;//If negative, increase the min value
        
    }

    public int top() {
        long top = stack.peek();
        if (top > 0){
            return (int)(top + min);
        } else {
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
    */



    // Using two stacks
    /*
    Deque<Integer> st;
    Deque<Integer> m;

    public Min_155() {
        st = new ArrayDeque<>();
        m = new ArrayDeque<>();
    }

    public void push(int x) {
        st.push(x);
        if (m.isEmpty())
            m.push(x);
        else
            m.push(Math.min(x, m.peek()));
    }

    public void pop() {
        st.pop();
        m.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return m.peek();
    }
    */
}

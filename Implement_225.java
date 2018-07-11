import java.util.LinkedList;
import java.util.Queue;

public class Implement_225 {
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

    // Standard Solution #1 (Two Queues, push O(1), pop O(n))
    /*
    class MyStack {
        private Queue<Integer> q1;
        private Queue<Integer> q2;
        int top;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q1.add(x);
            top = x;
        }

        public int pop() {
            while (q1.size() > 1) {
                top = q1.remove();
                q2.add(top);
            }
            int pop = q1.remove();
            Queue<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
            return pop;
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
    */

    // Standard Solution #3 (One Queue, push O(n), pop O(1))
    class MyStack {
        private Queue<Integer> q1;

        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q1.add(x);
            int sz = q1.size();
            while(sz > 1) {
                sz--;
                q1.add(q1.remove());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q1.remove();
        }

        /** Get the top element. */
        public int top() {
            return q1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }
}

import java.util.Stack;

public class Implement_232 {
    class MyQueue {
        // Standard Solution #2 (Two Stacks)
        // Time Complexity: Push->O(1), Pop->Amoritized O(1)
        Stack<Integer> s1;
        Stack<Integer> s2;
        int front;
        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (s1.isEmpty())
                front = x;
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (s2.isEmpty()) {
                while (s1.size() > 0)
                    s2.push(s1.pop());
            }
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (!s2.isEmpty())
                return s2.peek();
            return front;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}

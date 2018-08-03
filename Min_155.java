import java.util.ArrayDeque;
import java.util.Deque;

public class Min_155 {
    // Most voted solution uses only one stack
    // https://leetcode.com/problems/min-stack/discuss/49031/Share-my-Java-solution-with-ONLY-ONE-stack

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
}

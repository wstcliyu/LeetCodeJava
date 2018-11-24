import java.util.Stack;

public class Score_856 {
    // Standard Approach 3: Count Layer
    public int scoreOfParentheses(String S) {
        int res = 0, layer = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                layer++;
            else {
                layer--;
                if (S.charAt(i - 1) == '(')
                    res += 1 << layer;
            }
        }
        return res;
    }


    // Standard Approach 2: Stack
    // Time: O(n), Space: O(n)
    /*
    public int scoreOfParentheses(String S) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (char c : S.toCharArray()) {
            if (c == '(')
                st.push(0);
            else if (c == ')') {
                int v = st.pop();
                int w = st.pop();
                st.push(w + Math.max(2 * v, 1));
            }
        }
        return st.peek();
    }
    */

    // Most voted solution rewrite it by using array instead of using stack
    /*
    public int scoreOfParentheses(String S) {
        int[] res = new int[30];
        int i = 0;
        for (char c : S.toCharArray()) {
            if (c == '(')
                res[++i] = 0;
            else if (c == ')')
                res[i - 1] += Math.max(2 * res[i--], 1);
        }
        return res[0];
    }
    */
}

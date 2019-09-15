import java.util.ArrayDeque;
import java.util.Deque;

class Reverse_1190 {
    // My first solution: stack
    public String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        stack.push(new StringBuilder());
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(new StringBuilder());
            } else if (c == ')') {
                StringBuilder sb = stack.pop().reverse();
                stack.peek().append(sb);
            } else {
                stack.peek().append(c);
            }
        }
        return stack.peek().toString();
    }
}
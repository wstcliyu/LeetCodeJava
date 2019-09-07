import java.util.ArrayDeque;
import java.util.Deque;

class Ternary_439 {
    // Most voted solution: stack
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0)
            return "";
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.getLast() == '?') {
                stack.removeLast(); // pop '?'
                char first = stack.removeLast();
                stack.removeLast(); // pop ':'
                char second = stack.removeLast();
                stack.addLast(c == 'T' ? first : second);
            } else {
                stack.addLast(c);
            }
        }
        return String.valueOf(stack.getFirst());
    }
}
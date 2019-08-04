import java.util.ArrayDeque;
import java.util.Deque;

class Evaluate_150 {
    // My first solution
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        String operator = "+-*/";
        for (String token : tokens) {
            if (operator.contains(token)) {
                int operand2 = stack.removeLast();
                int operand1 = stack.removeLast();
                switch (token.charAt(0)) {
                    case '+': stack.add(operand1 + operand2); break;
                    case '-': stack.add(operand1 - operand2); break;
                    case '*': stack.add(operand1 * operand2); break;
                    case '/': stack.add(operand1 / operand2); break;
                }
            } else {
                stack.add(Integer.valueOf(token));
            }
        }
        return stack.getLast();
    }
}
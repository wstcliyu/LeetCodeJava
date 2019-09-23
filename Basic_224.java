import java.util.*;

class Basic {
    // My first solution: Stack
    class Pair {
        int val, sig;
        Pair(int _s) {
            val = 0;
            sig = _s;
        }
    }
    
    public int calculate(String s) {
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(1));
        char[] C = s.toCharArray();
        int value = 0, sign = 1;
        for (int i = 0; i < C.length; i++) {
            if (i > 0 && !Character.isDigit(C[i]) && Character.isDigit(C[i - 1])) {
                stack.peek().val += value * sign;
                value = 0;
                sign = 1;
            }
            
            if (C[i] == '+') sign = 1;
            if (C[i] == '-') sign = -1;
            if (Character.isDigit(C[i])) {
                value = value * 10 - '0' + C[i];
                if (i == C.length - 1)
                    stack.peek().val += value * sign;
            }
            if (C[i] == '(') {
                stack.push(new Pair(sign));
                sign = 1;
            }
            if (C[i] == ')') {
                Pair p = stack.pop();
                stack.peek().val += p.val * p.sig;
            }
        }
        return stack.peek().val;
    }
}
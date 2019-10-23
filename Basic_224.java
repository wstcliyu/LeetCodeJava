import java.util.*;

class Basic {
    // Rewrite Basic_772
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                nums.push(num);
            }
            if (c == '(') {
                ops.push(c);
            }
            if (c == ')') {
                while (ops.peek() != '(') {
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            }
            if (c == '+' || c == '-') {
                if (!ops.isEmpty() && ops.peek() != '(') {
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }
    

    private int operation(char op, int right, int left) {
        switch (op) {
            case '+': return left + right;
            case '-': return left - right;
            case '*': return left * right;
            case '/': return left / right;
        }
        return 0;
    }



    // My first solution: Stack
    /*
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
    */
}
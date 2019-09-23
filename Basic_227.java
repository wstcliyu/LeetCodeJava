import java.util.Stack;

class Basic_227 {
    // Rewrite most voted solution
    public int calculate(String s) {
        int res = 0;
        int num = 0;
        int cur = 0;
        char preOp = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            
            if ("+-*/".contains(c + "") || i == s.length() - 1) {
                switch (preOp) {
                    case '+': cur = num; break;
                    case '-': cur = -num; break;
                    case '*': cur *= num; break;
                    case '/': cur /= num; break;
                }
                
                if (c == '+' || c == '-' || i == s.length() - 1) {
                    res += cur;
                    cur = 0;
                }
                
                preOp = c;
                num = 0;
            }
        }
        
        return res;
    }



    // Most voted solution: Stack (it is also possible to use array as stack)
    /*
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                num = num * 10 + s.charAt(i) - '0';

            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '-')
                    stack.push(-num);
                if (sign == '+')
                    stack.push(num);
                if (sign == '*')
                    stack.push(stack.pop() * num);
                if (sign == '/')
                    stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        for (int i : stack) res += i;
        return res;
    }
    */


    // My first solution
    /*
    public int calculate(String s) {
        int res = 0;
        int num = 0, sign = 1;
        int cur = 0;
        char op = 0;
        for (int i = 0; i <= s.length(); i++) {
            char c = i < s.length() ? s.charAt(i) : 0;
            
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            
            if (i == s.length() || c == '+' || c == '-' || c == '*' || c == '/') {
                if (op == '*') {
                    cur = cur * num;
                } else if (op == '/') {
                    cur = cur / num;
                } else {
                    cur = num;
                }
                
                num = 0;
                op = c;
                
                if (i == s.length() || c == '+' || c == '-') {
                    res += cur * sign;
                    cur = 0;
                    sign = c == '+' ? 1 : -1;
                }
            }
        }
        
        return res;
    }
    */
}
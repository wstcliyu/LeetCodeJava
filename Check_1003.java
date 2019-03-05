public class Check_1003 {
	// Most voted solution using a stack
	// Keep a stack, whenever meet 'c',
	// pop a and b at the end of stack.
	// Otherwise return false.
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') return false;
                if (stack.isEmpty() || stack.pop() != 'a') return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }



	// My solution: Brute Force
	/*
	public boolean isValid(String S) {
        if (S.length() % 3 != 0) return false;
        while (!S.isEmpty() && S.contains("abc")) {
            // int idx = S.indexOf("abc");
            // S = S.substring(0, idx) + S.substring(idx + 3);
            S = S.replace("abc", "");
        }
        return S.isEmpty();
    }
    */
}
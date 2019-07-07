import java.util.Deque;
import java.util.ArrayDeque;

class Remove_1047 {
    // My first solution
    /*
    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.getLast() == c) {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
    */


    // Standard solution
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
    	for (char character : S.toCharArray()) {
      	    if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
      	    else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }
}

import java.util.*;
import javafx.util.Pair;

class Recover_1028 {
    // My first solution
    public TreeNode recoverFromPreorder(String S) {
        TreeNode dummy = new TreeNode(0);
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.addLast(new Pair<>(dummy, -1));
        int depth = 0, value = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-')
                depth++;
            else {
                value = value * 10 + S.charAt(i) - '0';
                if (i == S.length() - 1 || S.charAt(i + 1) == '-') {
                    TreeNode child = new TreeNode(value);
                    if (depth > stack.getLast().getValue())
                        stack.getLast().getKey().left = child;
                    else {
                        while (depth <= stack.getLast().getValue())
                            stack.removeLast();
                        stack.removeLast().getKey().right = child;
                    }
                    stack.addLast(new Pair<>(child, depth));
                    depth = 0;
                    value = 0;
                }
            }
        }
        
        return dummy.left;
    }




    // Rewrite most voted solution in Java
    /*
    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int i = 0;
        while (i < S.length()) {
            int depth = 0;
            String value = "";
            
            while (i < S.length() && S.charAt(i) == '-') {
                depth++; i++;
            }
            
            while (i < S.length() && S.charAt(i) != '-') {
                value += S.charAt(i); i++;
            }
            
            while (stack.size() > depth) stack.removeLast();
            TreeNode child = new TreeNode(Integer.valueOf(value));
            
            if (!stack.isEmpty()) {
                if (stack.getLast().left == null)
                    stack.getLast().left = child;
                else
                    stack.getLast().right = child;
            }
            stack.add(child);
        }
        return stack.getFirst();
    }
    */
}
import java.util.*;

class Construct_536 {
    // My first solution
    public TreeNode str2tree(String s) {
        if (s.isEmpty()) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(new TreeNode(0));
        int sign = 1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                TreeNode node = stack.getLast();
                node.val = 10 * node.val + sign * (c - '0');
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.addLast(new TreeNode(0));
                sign = 1;
            } else if (c == ')') {
                TreeNode node = stack.removeLast();
                TreeNode parent = stack.getLast();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
        }
        return stack.getFirst();
    }
}
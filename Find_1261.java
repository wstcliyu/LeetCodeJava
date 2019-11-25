import java.util.Stack;
import javafx.util.Pair;

class Find_1261 {
    // Time: O(N) initialization, O(lgN) query
    // Space: O(lgN) initialization, O(1) query
    private TreeNode root;

    public FindElements(TreeNode root) {
        this.root = root;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode node = p.getKey();
            int v = p.getValue();
            node.val = v;
            if (node.right != null)
                stack.push(new Pair<>(node.right, 2 * v + 2));
            if (node.left != null)
                stack.push(new Pair<>(node.left, 2 * v + 1));
        }
    }
    
    // Assume the value of every node is greater than its value by 1
    // Assume the root value is 1, its left and right are 2 and 3......
    public boolean find(int target) {
        target += 1;
        TreeNode node = root;
        boolean valid = false;
        for (int i = 31; node != null && i >= 0; i--) {
            if ((target & (1 << i)) != 0) {
                if (valid) {
                    node = node.right;
                } else {
                    valid = true;
                }
            } else if (valid) {
                node = node.left;
            }
        }
        return node != null;
    }
}
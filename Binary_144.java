import java.util.*;

public class Binary_144 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null)
            stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode p = stack.pop();
            result.add(p.val);
            if (p.right != null)
                stack.push(p.right);
            if (p.left != null)
                stack.push(p.left);
        }
        return result;

        // Post Order Traverse
        /*
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null)
            stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode p = stack.pop();
            result.addFirst(p.val);
            if (p.left != null)
                stack.push(p.left);
            if (p.right != null)
                stack.push(p.right);
        }
        return result;
        */
    }
}

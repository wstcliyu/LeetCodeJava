import java.util.LinkedList;

public class Find_513 {
    // BFS, right to left
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            root = q.remove();
            if (root.right != null) q.add(root.right);
            if (root.left != null) q.add(root.left);
        }
        return root.val;
    }
}

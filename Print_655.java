import java.util.ArrayList;
import java.util.List;

public class Print_655 {
    // My first solution
    public List<List<String>> printTree(TreeNode root) {
        int d = depth(root);
        int width = (int)Math.pow(2, d) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < width; j++)
                res.get(i).add("");
        }
        helper(root, res, 0, 0, width - 1);
        return res;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    private void helper(TreeNode root, List<List<String>> res, int depth, int start, int end) {
        if (root == null) return;
        int mid = (start + end) / 2;
        res.get(depth).set(mid, String.valueOf(root.val));
        helper(root.left, res, depth + 1, start, mid - 1);
        helper(root.right, res, depth + 1, mid + 1, end);
    }
}

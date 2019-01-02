import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Binary_102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int len = q.size();
            for (int i=0; i<len; i++) {
                TreeNode tmp = q.removeFirst();
                level.add(tmp.val);
                if (tmp.left != null)
                    q.add(tmp.left);
                if (tmp.right != null)
                    q.add(tmp.right);
            }
            res.add(level);
        }
        return res;
    }
}

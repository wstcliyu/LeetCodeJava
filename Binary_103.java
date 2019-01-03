import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Binary_103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while (!q.isEmpty()) {
            depth++;
            // Here we cannot use List<Integer> level =
            // Because there is no addFirst method for List
            // If we want to use List<Integer> level =
            // We must use level.add(0, tmp.val)
            LinkedList<Integer> level = new LinkedList<>();
            int len = q.size();
            for (int i=0; i<len; i++) {
                TreeNode tmp = q.poll();
                if (depth % 2 == 1)
                    level.add(tmp.val);
                else
                    level.addFirst(tmp.val);
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

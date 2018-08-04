import java.util.LinkedList;

public class Minimum_111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        // Most voted solution using recursion
        /*
        if(root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
        */

        // My solution using queue, similar with Binary_102
        int res = 0;
        if (root == null)
            return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            res++;
            int len = q.size();
            for (int i=0; i<len; i++) {
                TreeNode tmp = q.poll();
                if (tmp.left == null && tmp.right == null)
                    return res;
                else {
                    if (tmp.left != null)
                        q.add(tmp.left);
                    if (tmp.right != null)
                        q.add(tmp.right);
                }
            }
        }
        return res;
    }
}

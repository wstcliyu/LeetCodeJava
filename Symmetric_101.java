public class Symmetric_101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isMirrorPair(root.left, root.right);
    }
    private boolean isMirrorPair(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null)
            return true;
        if (n1 != null && n2 == null)
            return false;
        if (n1 == null)
            return false;
        if (n1.val != n2.val)
            return false;
        return isMirrorPair(n1.left, n2.right) && isMirrorPair(n1.right, n2.left);
    }

    // Standard solution #1 (Recursive), similar as mine but better writing
    /*
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
    */

    /* Standard solution #2 (Iterative), with Queue to do bfs
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
    */
}

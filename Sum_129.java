public class Sum_129 {
    // https://leetcode.com/problems/sum-root-to-leaf-numbers/discuss/41383/Python-solutions-(dfs%2Bstack-bfs%2Bqueue-dfs-recursively).
    // Python solutions (dfs+stack, bfs+queue, dfs recursively).

    // My solution using recursion with global variable
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int pre) {
        if (root == null) return;
        int newPre = root.val + 10 * pre;
        if (root.left == null && root.right == null)
            sum += newPre;
        else {
            dfs(root.left, newPre);
            dfs(root.right, newPre);
        }
    }


    // Most voted solution using recursion (a little similar with tail recursion)
    /*
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }
    */
}

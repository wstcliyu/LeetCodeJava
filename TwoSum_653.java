import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TwoSum_653 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Approach #1 using dfs and HashSet
    // Time: O(n)
    // Space: O(n)
    /*
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }
    private boolean dfs(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
    */

    // Approach #2 using bfs and HashSet
    // Time: O(n)
    // Space: O(n)
    /*
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        HashSet<Integer> set = new HashSet<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if (set.contains(k - tmp.val))
                return true;
            set.add(tmp.val);
            if (tmp.left != null)
                q.add(tmp.left);
            if (tmp.right != null)
                q.add(tmp.right);
        }
        return false;
    }
    */
    // Approach #3 using BST InOrder Traversal
    // Time: O(n)
    // Space: O(n)
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> ls = new ArrayList<>();
        inorderBST(root, ls);
        int l = 0, r = ls.size() - 1;
        while (l < r) {
            if (ls.get(l) + ls.get(r) < k)
                l++;
            else if (ls.get(l) + ls.get(r) > k)
                r--;
            else
                return true;
        }
        return false;
    }
    private void inorderBST(TreeNode root, List<Integer> ls) {
        if (root == null)
            return;
        inorderBST(root.left, ls);
        ls.add(root.val);
        inorderBST(root.right, ls);
    }
}

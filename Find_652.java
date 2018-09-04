import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Find_652 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // https://leetcode.com/problems/find-duplicate-subtrees/solution/
    // Standard Solution Approach #1 DFS
    // Time: O(n^2), Space: O(n^2)
    /*
    HashMap<String, Integer> count;
    List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        res = new ArrayList<>();
        collect(root);
        return res;
    }

    private String collect(TreeNode root) {
        if (root == null)
            return "#";
        String serial = root.val + "," + collect(root.left) + "," + collect(root.right);
        count.put(serial, 1 + count.getOrDefault(serial, 0));
        if (count.get(serial) == 2)
            res.add(root);
        return serial;
    }
    */


    // Standard Solution Approach #2 Unique Identifier
    // An improved version of Approach #1
    // Time: O(n), Space: O(n)
    HashMap<Integer, Integer> count;
    HashMap<String, Integer> trees;
    List<TreeNode> res;
    int t;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        trees = new HashMap<>();
        res = new ArrayList<>();
        t = 1;
        lookup(root);
        return res;
    }

    private int lookup(TreeNode root) {
        if (root == null)
            return 0;
        String serial = root.val + "," + lookup(root.left) + "," + lookup(root.right);
        int uid = trees.computeIfAbsent(serial, x -> t++);
        count.put(uid, 1 + count.getOrDefault(uid, 0));
        if (count.get(uid) == 2)
            res.add(root);
        return uid;
    }


    // My first solution (not accepted)
    /*
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<>();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        helper(res, nodes, root);
        return res;
    }

    private void helper(ArrayList<TreeNode> res, ArrayList<TreeNode> nodes, TreeNode root) {
        if (root == null)
            return;
        // java.util.ConcurrentModificationException
        // We cannot modify nodes when we iterate through it
        for (TreeNode node : nodes) {
            if (isEqualTree(node, root)) {
                res.add(root);
                nodes.remove(node);
            }
        }
        nodes.add(root);
        helper(res, nodes, root.left);
        helper(res, nodes, root.right);
    }

    private boolean isEqualTree(TreeNode x, TreeNode y) {
        if (x == null && y == null)
            return true;
        if (x == null || y == null)
            return false;
        return x.val == y.val && isEqualTree(x.left, y.left) && isEqualTree(x.right, y.right);
    }
    */
}

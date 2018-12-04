import javafx.util.Pair;

import java.util.HashMap;

public class Smallest_865 {
    // https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/discuss/146786/Simple-recursive-Java-Solution
    /*
    public int depth(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int max = 1 + Math.max(depth(root.left, map), depth(root.right, map));
        map.put(root, max);
        return max;
    }

    public TreeNode dfs(TreeNode root, HashMap<TreeNode, Integer> map) {
        int left = depth(root.left, map);
        int right = depth(root.right, map);
        if (left == right) return root;
        if (left < right) return dfs(root.right, map);
        else return dfs(root.left, map);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        HashMap<TreeNode, Integer> map = new HashMap<>();
        depth(root, map);
        return dfs(root, map);
    }
    */


    // https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/discuss/146808/One-pass
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).getValue();
    }

    private Pair<Integer, TreeNode> deep(TreeNode root) {
        if (root == null) return new Pair<>(0, null);
        Pair<Integer, TreeNode> l = deep(root.left), r = deep(root.right);
        int d1 = l.getKey(), d2 = r.getKey();
        return new Pair<>(1 + Math.max(d1, d2), d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
    }
}

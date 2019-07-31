import java.util.*;

class Delete_1110 {
    // Most voted solution from lee215
    Set<Integer> to_delete_set;
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        to_delete_set = new HashSet<>();
        for (int i : to_delete)
            to_delete_set.add(i);
        helper(root, true);
        return res;
    }

    private TreeNode helper(TreeNode node, boolean is_root) {
        if (node == null) return null;
        boolean deleted = to_delete_set.contains(node.val);
        if (is_root && !deleted) res.add(node);
        node.left = helper(node.left, deleted);
        node.right =  helper(node.right, deleted);
        return deleted ? null : node;
    }



    // My first solution
    /*
    List<TreeNode> res;
    Set<Integer> set;
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        set = new HashSet<>();
        for (int d : to_delete) set.add(d);
        delNodes(root, null, true);
        return res;
    }
    
    private void delNodes(TreeNode node, TreeNode parent, boolean left) {
        if (node == null) return;
        if (set.contains(node.val)) {
            if (parent != null) {
                if (left) parent.left = null;
                else parent.right = null;
            }
            delNodes(node.left, null, true);
            delNodes(node.right, null, false);
        } else {
            if (parent == null) {
                res.add(node);
            }
            delNodes(node.left, node, true);
            delNodes(node.right, node, false);
        }
    }
    */
}

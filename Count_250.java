class Count_250 {
    // My solution similar to standard approach #1: DFS
    /*
    private int res;
    
    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        isUni(root);
        return res;
    }
    
    private boolean isUni(TreeNode root) {
        if (root == null) return true;
        boolean l = isUni(root.left);
        boolean r = isUni(root.right);
        if (l && r && (root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
            res++;
            return true;
        }
        return false;
    }
    */



    // Standard Approach #2: DFS - Pass Parent Values
    int count = 0;

    boolean is_valid_part(TreeNode node, int val) {

        // considered a valid subtree
        if (node == null) return true;

        // check if node.left and node.right are univalue subtrees of value node.val
        // note that || short circuits but | does not - both sides of the or get evaluated with | so we explore all possible routes
        if (!is_valid_part(node.left, node.val) | !is_valid_part(node.right, node.val)) return false;

        // if it passed the last step then this a valid subtree - increment
        count++;

        // at this point we know that this node is a univalue subtree of value node.val
        // pass a boolean indicating if this is a valid subtree for the parent node
        return node.val == val;
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        is_valid_part(root, 0);
        return count;
    }
}
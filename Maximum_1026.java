class Maximum_1026 {
    // My first solution: Bottom-up
    int res = 0;
    
    public int maxAncestorDiff(TreeNode root) {
        getMinAndMax(root);
        return res;
    }
    
    private int[] getMinAndMax(TreeNode node) {
        int min = node.val, max = node.val;

        if (node.left != null) {
            int[] leftRange = getMinAndMax(node.left);
            res = Math.max(res, Math.abs(node.val - leftRange[0]));
            res = Math.max(res, Math.abs(node.val - leftRange[1]));
            min = Math.min(min, leftRange[0]);
            max = Math.max(max, leftRange[1]);
        }
        
        if (node.right != null) {
            int[] rightRange = getMinAndMax(node.right);
            res = Math.max(res, Math.abs(node.val - rightRange[0]));
            res = Math.max(res, Math.abs(node.val - rightRange[1]));
            min = Math.min(min, rightRange[0]);
            max = Math.max(max, rightRange[1]);
        }
        
        return new int[]{min, max};
    }




    // Most voted solution: Top-down
    // Track the min and max along the path towards a leaf
    /*
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, 100_000, 0);
    }
    
    private int maxAncestorDiff(TreeNode root, int min, int max) {
        if (root == null) return max - min;
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        return Math.max(maxAncestorDiff(root.left, min, max), maxAncestorDiff(root.right, min, max));
    }
    */
}
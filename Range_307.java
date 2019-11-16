class Range_307 {
    // My solution
    SegmentTreeNode root;

    public NumArray(int[] nums) {
        root = buildTree(0, nums.length - 1, nums);
    }
    
    public void update(int i, int val) {
        modify(root, i, val);
    }
    
    public int sumRange(int i, int j) {
        return query(root, i, j);
    }
    
    private int query(SegmentTreeNode node, int i, int j) {
        if (i > j || node == null || i > node.r || j < node.l) return 0;
        if (i <= node.l && j >= node.r) return node.sum;
        return query(node.left, i, j) + query(node.right, i, j);
    }
    
    private void modify(SegmentTreeNode node, int i, int val) {
        if (node == null || i > node.r || i < node.l) return;
        if (i == node.l && i == node.r) {
            node.sum = val;
            return;
        }
        modify(node.left, i, val);
        modify(node.right, i, val);
        node.sum = node.left.sum + node.right.sum;
    }
    
    private SegmentTreeNode buildTree(int i, int j, int[] nums) {
        if (i > j) return null;
        if (i == j) return new SegmentTreeNode(i, i, nums[i]);
        SegmentTreeNode root = new SegmentTreeNode(i, j, 0);
        int m = (i + j) / 2;
        root.left = buildTree(i, m, nums);
        root.right = buildTree(m + 1, j, nums);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    
    class SegmentTreeNode {
        int l, r;
        int sum;
        SegmentTreeNode left, right;
        SegmentTreeNode(int l, int r, int sum) {
            this.l = l;
            this.r = r;
            this.sum = sum;
            this.left = this.right = null;
        }
    }
}
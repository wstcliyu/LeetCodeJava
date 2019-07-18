class Closest_270 {
    // Standard solution
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            int val = root.val;
            res = Math.abs(val - target) < Math.abs(res - target) ? val : res;
            root = target < val ? root.left : root.right;
        }
        return res;
    }



    // My first solution
    // Compare double with integer
    /*
    public int closestValue(TreeNode root, double target) {
        int prev = Integer.MIN_VALUE;
        int post = Integer.MAX_VALUE;
        TreeNode node = root;
        while (node != null) {
            if (target > node.val) {
                prev = node.val;
                node = node.right;
            } else if (target < node.val) {
                post = node.val;
                node = node.left;
            } else {
                return node.val;
            }
        }
        int res = 0;

        if (prev != Integer.MIN_VALUE)
            res = prev;
        else
            return post;
        if (post != Integer.MAX_VALUE && post - target < target - prev)
            res = post;

        return res;
    }
    */
}

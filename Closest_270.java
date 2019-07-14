class Closest_270 {
    // Compare double with integer
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
}
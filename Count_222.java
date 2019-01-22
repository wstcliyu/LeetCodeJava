public class Count_222 {
    // Time: O(log(n)^2)
    private int height(TreeNode root) {
        return root == null ? 0 : 1 + height(root.left);
    }


    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = height(root.left);
        if (h == height(root.right)) return (1 << h) + countNodes(root.right);
        else return (1 << (h - 1)) + countNodes(root.left);
    }

    // Iterative version of the recursion above
    /*
    public int countNodes(TreeNode root) {
        int res = 0;
        while (root != null) {
            int h = height(root.left);
            if (h == height(root.right)) {
                res += 1 << h;
                root = root.right;
            } else {
                res += 1 << (h - 1);
                root = root.left;
            }
            h--;
        }
        return res;
    }
    */


    // It first walks all the way left and right to determine the height
    // and whether it's a full tree, meaning the last row is full.
    // If so, then the res is just 2^height-1.
    // Since always at least one of the two recursive calls is such a full tree,
    // at least one of the two calls immediately stops.
    // Again we have runtime O(log(n)^2).
    /*
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null)
            return (1 << height) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    */
}

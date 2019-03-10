public class Construct_1008 {
	// My first solution
	int i = 0;
    int[] A;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        this.A = preorder;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int min, int max) {
        if (i == A.length || A[i] < min || A[i] > max)
            return null;
        TreeNode node = new TreeNode(A[i++]);
        node.left = helper(min, node.val);
        node.right = helper(node.val, max);
        return node;
    }



    // Most voted solution using recursion
    // Only need to save the upper bound
    /*
    int i = 0;

    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
    */



    // Iterative version using stack
    /*
    public TreeNode bstFromPreorder(int[] preorder) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        stack.addLast(dummy);
        for (int a : preorder) {
            TreeNode node = new TreeNode(a);
            TreeNode p = null;
            while (stack.getLast().val < a) {
                p = stack.removeLast();
            }
            if (p != null) {
                p.right = node;
            } else {
                stack.getLast().left = node;
            }
            stack.addLast(node);
        }
        return dummy.left;
    }
    */
}
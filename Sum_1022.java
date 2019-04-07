class Sum_1022 {
    // My first solution using recursion
    // Alternative solution in my mind: level-order traversal (BFS)
    int sum;
    
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode node, int prefix) {
        prefix = (prefix << 1) + node.val;
        if (node.left == null && node.right == null)
            sum += prefix;
        if (node.left != null)
            dfs(node.left, prefix);
        if (node.right != null)
            dfs(node.right, prefix);
    }




    // My first solution using iterative pre-order traversal
    /*
    public int sumRootToLeaf(TreeNode root) {
        int sum = 0;
        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(root, 0));
        while (!deque.isEmpty()) {
            Pair<TreeNode, Integer> pair = deque.removeLast();
            TreeNode node = pair.getKey();
            int prefix = (pair.getValue() << 1) + node.val;
            if (node.left == null && node.right == null)
                sum += prefix;
            if (node.right != null)
                deque.add(new Pair<>(node.right, prefix));
            if (node.left != null)
                deque.add(new Pair<>(node.left, prefix));
        }
        return sum;
    }
    */
}
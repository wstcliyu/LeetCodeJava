public class Cousins_993 {
	private TreeNode parentX, parentY;
    private int depthX, depthY;
    private int valueX, valueY;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        valueX = x;
        valueY = y;
        dfs(null, root, 0);
        return depthX == depthY && parentX.val != parentY.val;
    }
    
    private void dfs(TreeNode parent, TreeNode node, int depth) {
        if (node == null || parentX != null && parentY != null) return;
        if (node.val == valueX) {
            parentX = parent;
            depthX = depth;
        }
        if (node.val == valueY) {
            parentY = parent;
            depthY = depth;
        }
        dfs(node, node.left, depth+1);
        dfs(node, node.right, depth+1);
    }
}
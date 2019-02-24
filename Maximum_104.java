import javafx.util.Pair;

public class Maximum_104 {
	public int maxDepth(TreeNode root) {
	    LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
	    if (root != null) stack.add(new Pair(root, 1));

	    int depth = 0;
	    while (!stack.isEmpty()) {
	      	Pair<TreeNode, Integer> current = stack.pollLast();
	      	root = current.getKey();
	      	int current_depth = current.getValue();
	     	if (root != null) {
	        	depth = Math.max(depth, current_depth);
	        	stack.add(new Pair(root.left, current_depth + 1));
	        	stack.add(new Pair(root.right, current_depth + 1));
	      	}
	    }
	    return depth;
	  }
}
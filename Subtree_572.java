public class Subtree_572 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // My first solution
    /*
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        else if (s == null && t != null)
            return false;
        return isEqualTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isEqualTree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        else if (s != null && t == null)
            return false;
        else if (s == null && t != null)
            return false;
        else if (s.val != t.val)
            return false;
        return isEqualTree(s.left, t.left) && isEqualTree(s.right, t.right);
    }
    */

    // Standard Solution Approach #2
    // Similar with my first solution, but better organized
    /*
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    public boolean equals(TreeNode x, TreeNode y) {
        if(x == null && y == null)
            return true;
        if(x == null || y == null)
            return false;
        return x.val == y.val && equals(x.left, y.left) && equals(x.right, y.right);
    }
    */


    // Standard Solution Approach #1
    // Pre-order Traversal Expression by String
    /*
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        return tree1.indexOf(tree2) >= 0;
    }
    public String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return "#" + t.val + " " + preorder(t.left, true) + " " + preorder(t.right, false);
    }
    */


    // I modified standard solution approach #1 because I don't understand
    // why we need to distinguish between "lnull" and "rnull"
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s);
        String tree2 = preorder(t);
        return tree1.indexOf(tree2) >= 0;
    }
    public String preorder(TreeNode t) {
        if (t == null)
            return "null";
        return "#" + t.val + " " + preorder(t.left) + " " + preorder(t.right);
    }


    // Most voted solution
    /*
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String spreorder = generatepreorderString(s); 
        String tpreorder = generatepreorderString(t);
        
        return spreorder.contains(tpreorder) ;
    }
    public String generatepreorderString(TreeNode s){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stacktree = new Stack();
        stacktree.push(s);
        while(!stacktree.isEmpty()){
           TreeNode popelem = stacktree.pop();
           if(popelem == null)
              sb.append(",#"); // Appending # inorder to handle same values but not subtree cases
           else {     
              sb.append("," + popelem.val);
              stacktree.push(popelem.right);    
              stacktree.push(popelem.left);}
        }
        return sb.toString();
    }
    */
}

class Inorder_510 {
    class Node {
        int val;
        Node left, right, parent;
    }

    // My first solution
    // Same as standard solution
    public Node inorderSuccessor(Node x) {
        if (x.right != null) {
            x = x.right;
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }
        
        while (x.parent != null && x.parent.right == x) {
            x = x.parent;
        }
        
        return x.parent;
    }
}
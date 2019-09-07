class Convert_426 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    // Standard solution
    Node first = null;
    Node last = null;

    public void helper(Node node) {
        if (node == null) return;
        helper(node.left);
        if (last != null) {
            last.right = node;
            node.left = last;
        } else {
            first = node;
        }
        last = node;
        helper(node.right);
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }



    // My solution (similar to standard solution)
    /*
    private Node prev, head, tail;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        
        head = root;
        while (head.left != null) {
            head = head.left;
        }
        
        tail = root;
        while (tail.right != null) {
            tail = tail.right;
        }
        prev = tail;
        
        inorder(root);
        return head;
    }
    
    private void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        
        prev.right = root;
        root.left = prev;
        prev = root;
    
        if (root == tail) return;
        inorder(root.right);
    }
    */
}
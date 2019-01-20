public class Populating_116 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    // Most voted solution using iteration (BFS)
    public void connect(TreeLinkNode root) {
        while(root != null && root.left != null) {
            TreeLinkNode next = root.left;
            while (root != null) {
                root.left.next = root.right;
                if (root.next != null) root.right.next = root.next.left;
                root = root.next;
            }
            root = next;
        }
    }


    // Recursion (DFS)
    /*
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) return;

        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left;

        connect(root.left);
        connect(root.right);
    }
    */


    // My solution using recursion (DFS)
    /*
    public void connect(TreeLinkNode root) {
        connect(root, null, true);
    }

    private void connect(TreeLinkNode node, TreeLinkNode parent, boolean left) {
        if (node == null) return;
        if (parent != null) {
            if (left)
                node.next = parent.right;
            else if (parent.next != null)
                node.next = parent.next.left;
        }
        connect(node.left, node, true);
        connect(node.right, node, false);
    }
    */
}

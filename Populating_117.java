public class Populating_117 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    // Iteration using dummy head (BFS)
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode dummyHead = new TreeLinkNode(0);
            TreeLinkNode pre = dummyHead;
            while (root != null) {
                if (root.left != null) { pre.next = root.left; pre = pre.next; }
                if (root.right != null) { pre.next = root.right; pre = pre.next; }
                root = root.next;
            }
            root = dummyHead.next;
        }
    }


    // My solution using iteration (BFS)
    /*
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode next = null;
        while (root != null) {
            if (next == null) next = root.left != null ? root.left : root.right;
            if (root.left != null) {
                if (root.right != null) root.left.next = root.right;
                else findNext(root.left, root.next);
            }
            if (root.right != null) findNext(root.right, root.next);
            if (root.next != null) root = root.next;
            else {
                root = next;
                next = null;
            }
        }
    }

    private void findNext(TreeLinkNode node, TreeLinkNode root) {
        while (node.next == null && root != null) {
            if (root.left != null) node.next = root.left;
            else if (root.right != null) node.next = root.right;
            else root = root.next;
        }
    }
    */
}

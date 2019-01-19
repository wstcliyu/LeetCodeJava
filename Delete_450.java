public class Delete_450 {
    // My solution using iteration
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root, parent = new TreeNode(0);
        parent.left = root;
        while(cur != null && cur.val != key) {
            parent = cur;
            if (cur.val > key) cur = cur.left;
            else cur = cur.right;
        }
        if (cur == null) return root;
        if (parent.left == cur) {
            if (cur.left == null && cur.right == null) parent.left = null;
            else if (cur.left == null) parent.left = cur.right;
            else if (cur.right == null) parent.left = cur.left;
            else {
                parent.left = cur.right;
                TreeNode p = cur.right;
                while (p.left != null) p = p.left;
                p.left = cur.left;
            }
        } else if (parent.right == cur) {
            if (cur.left == null && cur.right == null) parent.right = null;
            else if (cur.left == null) parent.right = cur.right;
            else if (cur.right == null) parent.right = cur.left;
            else {
                parent.right = cur.right;
                TreeNode p = cur.right;
                while (p.left != null) p = p.left;
                p.left = cur.left;
            }
        }
        return cur == root ? parent.left : root;
    }


    // Most voted solution using recursion and
    // updating the val of root with the smallest value of right subtree
    /*
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
    */
}

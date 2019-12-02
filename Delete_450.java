public class Delete_450 {
    // Rewrite method on CLRS
    private void transplant(TreeNode u, TreeNode v, TreeNode pu) {
        if (pu.left == u) {
            pu.left = v;
        } else {
            pu.right = v;
        }
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode z = root;
        TreeNode zp = new TreeNode(0);
        zp.left = root;
        while(z != null && z.val != key) {
            zp = z;
            if (z.val > key) z = z.left;
            else z = z.right;
        }
        if (z == null) return root;
        if (z.left == null) {
            transplant(z, z.right, zp);
        } else if (z.right == null) {
            transplant(z, z.left, zp);
        } else {
            TreeNode y = z.right;
            if (y.left != null) {
                TreeNode yp = z;
                while (y.left != null) {
                    yp = y;
                    y = y.left;
                }
                transplant(y, y.right, yp);
                y.right = z.right;
            }
            
            transplant(z, y, zp);
            y.left = z.left;
        }
        return z == root ? zp.left : root;
    }



    // My solution using iteration
    /*
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
    */



    // I don't think this tricky solution would work in reality
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

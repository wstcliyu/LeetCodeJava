import java.util.LinkedList;

public class Complete_919 {
    // Standard solution using two queues
    // One queue to traverse the tree, the other to store parent nodes under which we can insert child

    // We can also just use one queue traverse. Break the while loop if (node.left == null || node.right == null)
    TreeNode root;
    LinkedList<TreeNode> q;

    public Complete_919(TreeNode root) {
        this.root = root;
        LinkedList<TreeNode> traverse = new LinkedList<>();
        q = new LinkedList<>();
        traverse.add(root);
        while (!traverse.isEmpty()) {
            TreeNode node = traverse.poll();
            if (node.left == null || node.right == null)
                q.add(node);
            if (node.left != null)
                traverse.add(node.left);
            if (node.right != null)
                traverse.add(node.right);
        }
    }

    public int insert(int v) {
        TreeNode parent = q.peek();
        TreeNode child = new TreeNode(v);
        if (parent.left == null)
            parent.left = child;
        else {
            parent.right = child;
            q.poll();
        }
        q.add(child);
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }


    // My first solution without using queue
    /*
    TreeNode root;
    int size;

    private void preTraverse(TreeNode root) {
        if (root != null) {
            size++;
            preTraverse(root.left);
            preTraverse(root.right);
        }
    }

    public Complete_919(TreeNode root) {
        this.root = root;
        preTraverse(root);
    }

    public int insert(int v) {
        size++;
        boolean b = false;
        TreeNode node = root;
        for (int i = 30; i >= 1; i--) {
            if (b) {
                if ((size & (1 << i)) != 0)
                    node = node.right;
                else
                    node = node.left;
            }
            if (!b && (size & (1 << i)) != 0)
                b = true;
        }
        if ((size & 1) == 0)
            node.left = new TreeNode(v);
        else
            node.right = new TreeNode(v);
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
    */
}

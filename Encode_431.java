import java.util.*;

class Encode_431 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Most voted solution

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) return null;
        TreeNode res = new TreeNode(root.val);
        if (root.children != null && root.children.size() > 0) {
            res.left = encode(root.children.get(0));
            TreeNode node = res.left;
            for (int i = 1; i < root.children.size(); i++) {
                node.right = encode(root.children.get(i));
                node = node.right;
            }
        }
        return res;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        Node res = new Node(root.val, new ArrayList<>());
        if (root.left != null) {
            res.children.add(decode(root.left));
            TreeNode node = root.left;
            while (node.right != null) {
                res.children.add(decode(node.right));
                node = node.right;
            }
        }
        return res;
    }
}
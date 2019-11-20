import java.util.*;

public class Serialize_297 {
    private static final String spliter = ",";
    private static final String NN = "X";

    // Recursive DFS

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null)
            sb.append(NN).append(spliter);
        else {
            sb.append(node.val).append(spliter);
            serialize(node.left, sb);
            serialize(node.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(spliter)));
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        String val = nodes.removeFirst();
        if (val.equals(NN)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);
        return node;
    }



    // Iterative DFS
    /*
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            TreeNode cur = st.pop();
            if (cur == null)
                sb.append(NN + spliter);
            else {
                sb.append(cur.val + spliter);
                st.push(cur.right);
                st.push(cur.left);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(spliter);
        if (nodes[0].equals(NN)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode cur = st.peek();
            TreeNode child = nodes[i].equals(NN) ? null : new TreeNode(Integer.valueOf(nodes[i]));
            if (nodes[i - 1].equals(NN))
                st.pop().right = child;
            else
                cur.left = child;
            if (child != null) st.push(child);
        }
        return root;
    }
    */



    // Iterative BFS
    /*
    public String serialize(TreeNode root) {
        // Cannot use Deque, ArrayDeque here
        // q.add(e) throws nullpointer exception when e is null
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append(NN + spliter);
                continue;
            }
            res.append(node.val + spliter);
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals(NN + spliter)) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(spliter);
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals(NN)) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals(NN)) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
    */
}

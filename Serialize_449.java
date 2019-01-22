import java.util.LinkedList;
import java.util.Queue;

public class Serialize_449 {
    // Refer to 297 for similar problem
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val + ",");
            serialize(node.left, sb);
            serialize(node.right,sb);
        }
    }


    int pos = 0;

    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] values = data.split(",");
        return deserialize(Integer.MIN_VALUE, Integer.MAX_VALUE, values);
    }

    private TreeNode deserialize(int min, int max, String[] values) {
        if (pos >= values.length) return null;
        int value = Integer.valueOf(values[pos]);
        if (value < min || value > max) return null;
        pos++;
        TreeNode root = new TreeNode(value);
        root.left = deserialize(min, value, values);
        root.right = deserialize(value, max, values);
        return root;
    }


    // Most voted solution for deserialization
    /*
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] strs = data.split(",");
        Queue<Integer> q = new LinkedList<>();
        for (String e : strs) q.offer(Integer.parseInt(e));
        return getNode(q);
    }
    //   5
    //  3 6
    // 2   7
    private TreeNode getNode(Queue<Integer> q) { //q: 5,3,2,6,7
        if (q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());//root (5)
        Queue<Integer> samllerQueue = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < root.val) {
            samllerQueue.offer(q.poll());
        }
        //smallerQueue : 3,2   storing elements smaller than 5 (root)
        root.left = getNode(samllerQueue);
        //q: 6,7   storing elements bigger than 5 (root)
        root.right = getNode(q);
        return root;
    }
    */
}

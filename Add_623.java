import java.util.LinkedList;
import java.util.Stack;

public class Add_623 {
    // Standard solution #1: Using recursion (DFS)
    public TreeNode addOneRow(TreeNode t, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        }
        insert(v, t, 1, d);
        return t;
    }

    public void insert(int val, TreeNode node, int depth, int n) {
        if (node == null)
            return;
        if (depth == n - 1) {
            TreeNode t = node.left;
            node.left = new TreeNode(val);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(val);
            node.right.right = t;
        } else {
            insert(val, node.left, depth + 1, n);
            insert(val, node.right, depth + 1, n);
        }
    }


    // Standard solution #2: Using stack (DFS)
    /*
    class Node{
        Node(TreeNode n,int d){
            node=n;
            depth=d;
        }
        TreeNode node;
        int depth;
    }
    public TreeNode addOneRow(TreeNode t, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        }
        Stack<Node> stack=new Stack<>();
        stack.push(new Node(t,1));
        while(!stack.isEmpty())
        {
            Node n=stack.pop();
            if(n.node==null)
                continue;
            if (n.depth == d - 1 ) {
                TreeNode temp = n.node.left;
                n.node.left = new TreeNode(v);
                n.node.left.left = temp;
                temp = n.node.right;
                n.node.right = new TreeNode(v);
                n.node.right.right = temp;

            } else{
                stack.push(new Node(n.node.left, n.depth + 1));
                stack.push(new Node(n.node.right, n.depth + 1));
            }
        }
        return t;
    }
    */


    // My first solution using BFS (similar with standard solution #3)
    /*
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode res = new TreeNode(v);
            res.left = root;
            return res;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (d > 1) {
            int N = q.size();
            if (--d == 1) {
                for (int i = 0; i < N; i++) {
                    TreeNode tmp = q.removeFirst();
                    TreeNode newLeft = new TreeNode(v);
                    TreeNode newRight = new TreeNode(v);
                    newLeft.left = tmp.left;
                    newRight.right = tmp.right;
                    tmp.left = newLeft;
                    tmp.right = newRight;
                }
                return root;
            } else {
                for (int i = 0; i < N; i++) {
                    TreeNode tmp = q.removeFirst();
                    if (tmp.left != null)
                        q.add(tmp.left);
                    if (tmp.right != null)
                        q.add(tmp.right);
                }
            }
        }
        return root;
    }
    */
}

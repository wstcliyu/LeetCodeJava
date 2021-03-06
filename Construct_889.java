import java.util.*;

public class Construct_889 {
    // Refer to Construct_105, Construct_106
    // Rewrite the most voted solution (following 105, 106)
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(pre[0]);
        st.push(root);
        for (int i = 1, j = 0; i < pre.length; i++) {
            TreeNode node = new TreeNode(pre[i]);
            if (post[j] != st.peek().val) {
                st.peek().left = node;
                st.push(node);
            } else {
                while (post[j] == st.peek().val) {
                    st.pop();
                    j++;
                }
                TreeNode p = st.peek();
                p.right = node;
                st.push(node);
            }
        }
        return root;
    }



    // Most voted solution from lee215
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C%2B%2BJavaPython-One-Pass-Real-O(N)
    /*
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        s.offer(new TreeNode(pre[0]));
        for (int i = 1, j = 0; i < pre.length; ++i) {
            TreeNode node = new TreeNode(pre[i]);
            while (s.getLast().val == post[j]) {
                s.pollLast(); j++;
            }
            if (s.getLast().left == null) s.getLast().left = node;
            else s.getLast().right = node;
            s.offer(node);
        }
        return s.getFirst();
    }
    */



    // Most voted solution from lee215
    /*
    int preIndex = 0, posIndex = 0;
    public TreeNode constructFromPrePost(int[]pre, int[]post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[posIndex])
            root.left = constructFromPrePost(pre, post);
        if (root.val != post[posIndex])
            root.right = constructFromPrePost(pre, post);
        posIndex++;
        return root;
    }
    */




    // My first solution using recursion, with a map to save index
    /*
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        getIndex(post);
        int end = pre.length - 1;
        return helper(pre, 0, end, post, 0, end);
    }

    private TreeNode helper(int[] pre, int s1, int e1, int[] post, int s2, int e2) {
        TreeNode root = new TreeNode(pre[s1]);
        if (s1 == e1)
            return root;
        int idx = map.get(pre[s1 + 1]);
        if (idx + 1 == e2) {
            root.left = helper(pre, s1 + 1, e1, post, s2, e2 - 1);
            return root;
        }
        int diff = idx - s2;
        root.left = helper(pre, s1 + 1, s1 + 1 + diff, post, s2, idx);
        root.right = helper(pre, s1 + 2 + diff, e1, post, idx + 1, e2 - 1);
        return root;
    }

    private void getIndex(int[] post) {
        for (int i = 0; i < post.length; i++)
            map.put(post[i], i);
    }
    */

    public static void main(String[] args) {
        Construct_889 test = new Construct_889();
        int[] testPre = {1,2,4,5,3,6,7};
        int[] testPost = {4,5,2,6,7,3,1};
        System.out.println(test.constructFromPrePost(testPre, testPost).val);
    }
}

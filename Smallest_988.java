public class Smallest_988 {

    // My first solution
    // I don't think the bottom-up solution online is correct, I have added testcase in the main method

    private String res;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        // dfs(root, "");
        return res;
    }

    private void dfs(TreeNode node, String prev) {
        if (node == null) return;
        char c = (char)(node.val + 'a');
        String path = c + prev;
        if (node.left == null && node.right == null && (res == null || res.compareTo(path) > 0))
            res = path;
        dfs(node.left, path);
        dfs(node.right, path);
    }

    private void dfs(TreeNode node, StringBuilder prev) {
        if (node == null) return;
        char c = (char)(node.val + 'a');
        prev.insert(0, c);
        if (node.left == null && node.right == null) {
            String p = prev.toString();
            if (res == null || res.compareTo(p) > 0)
                res = p;
        }
        dfs(node.left, prev);
        dfs(node.right, prev);
        prev.deleteCharAt(0);
    }



    public static void main(String[] args) {
        String x = "a";
        String y = "aa";
        char c = 'z';
        System.out.println(x.compareTo(y));
        System.out.println((x+c).compareTo(y+c));
    }
}

import java.util.ArrayList;
import java.util.HashMap;

public class Most_508 {
    // My solution is the same as the most voted solution
    HashMap<Integer, Integer> freq = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        ArrayList<Integer> ls = new ArrayList<>();
        for (int sum : freq.keySet()) {
            if (freq.get(sum) == max)
                ls.add(sum);
        }
        int[] res = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++)
            res[i] = ls.get(i);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int sum = root.val + dfs(root.left) + dfs(root.right);
        int frequency = 1 + freq.getOrDefault(sum, 0);
        max = Math.max(frequency, max);
        freq.put(sum, frequency);
        return sum;
    }
}

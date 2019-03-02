import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Sum_834 {
    // Most voted solution
    // https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130583/C%2B%2BJavaPython-Pre-order-and-Post-order-DFS-O(N)

    // 0. Let's solve it with node 0 as root.
    // 1. Initial an array of hashset tree, tree[i] contains all connected nodes to i.
    //    Initial an array count, count[i] counts all nodes in the subtree i.
    //    Initial an array of res, res[i] stores sum of distance in subtree i.
    // 2. Post order dfs traversal, update count and res:
    //    count[root] = sum(count[i]) + 1
    //    res[root] = sum(res[i]) + sum(count[i])
    // 3. Pre order dfs traversal, update res:
    //    When we move our root from parent to its child i, count[i] points get 1 closer to root, n - count[i] nodes get 1 further to root.
    //    res[i] = res[root] - count[i] + N - count[i]
    // 4. Return res, done.


    int n;
    int[] res, count;
    ArrayList<HashSet<Integer>> tree;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        n = N;
        res = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);
        tree = new ArrayList<>();
        for (int i = 0; i < N; i++)
            tree.add(new HashSet<>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        postorder(0, -1);
        preorder(0, -1);
        return res;
    }

    private void postorder(int node, int parent) {
        for (int i : tree.get(node)) {
            if (i != parent) {
                postorder(i, node);
                count[node] += count[i];
                res[node] += res[i] + count[i];
            }
        }
    }

    private void preorder(int node, int parent) {
        for (int i : tree.get(node)) {
            if (i != parent) {
                res[i] = res[node] - count[i] + n - count[i];
                preorder(i, node);
            }
        }
    }
}

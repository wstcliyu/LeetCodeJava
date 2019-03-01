import java.util.*;

public class Vertical_987 {
    // Second voted solution use HashMap as outer map, and keep track of the minX and maxX
    // Similar with Binary_314

    // Most voted solution using TreeMap
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> line : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> pq : line.values()) {
                while (!pq.isEmpty())
                    res.get(res.size()-1).add(pq.poll());
            }
        }
        return res;
    }

    private void dfs(TreeNode node, int x, int y) {
        if (node == null) return;
        map.putIfAbsent(x, new TreeMap<>());
        map.get(x).putIfAbsent(y, new PriorityQueue<>());
        map.get(x).get(y).add(node.val);
        dfs(node.left, x-1, y+1);
        dfs(node.right, x+1, y+1);
    }



    // Standard solution: Store and sort locations
    /*
    class Location implements Comparable<Location> {
        int x, y, val;

        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Location that) {
            if (this.x != that.x)
                return Integer.compare(this.x, that.x);
            else if (this.y != that.y)
                return Integer.compare(this.y, that.y);
            else
                return Integer.compare(this.val, that.val);
        }
    }

    List<Location> locations;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Each location is a node's x position, y position, and value
        locations = new ArrayList<>();
        dfs(root, 0, 0);
        Collections.sort(locations);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        int prev = locations.get(0).x;

        for (Location loc: locations) {
            // If the x value changed, it's part of a new report.
            if (loc.x != prev) {
                prev = loc.x;
                ans.add(new ArrayList<>());
            }

            // We always add the node's value to the latest report.
            ans.get(ans.size() - 1).add(loc.val);
        }

        return ans;
    }

    public void dfs(TreeNode node, int x, int y) {
        if (node != null) {
            locations.add(new Location(x, y, node.val));
            dfs(node.left, x-1, y+1);
            dfs(node.right, x+1, y+1);
        }
    }
    */
}

import java.util.*;

public class Number_933 {
    // My first solution using queue
    // Time: O(n), Space: O(min(n, 3000))

    LinkedList<Integer> ls;

    public Number_933() {
        ls = new LinkedList<>();
    }

    public int ping(int t) {
        ls.add(t);
        while (ls.peek() < t - 3000)
            ls.poll();
        return ls.size();
    }


    // https://leetcode.com/problems/number-of-recent-calls/discuss/189239/Java-Three-solutions%3A-TreeMap-TreeSet-ArrayList-All-time-O(logN).
    // Three solutions: TreeMap , TreeSet, ArrayList; All Time O(logN), Space O(N)
    // Method 1: TreeMap
    // TreeMap.tailMap() and put() both cost time O(logN)
    /*
    TreeMap<Integer, Integer> tm;

    public RecentCounter() {
        tm = new TreeMap<>();
    }

    public int ping(int t) {
        tm.put(t, 1 + tm.size());
        return tm.tailMap(t - 3000).size();
    }
    */

    // Method 2: TreeSet
    // TreeSet.tailSet() and add() both cost time O(logN)
    /*
    TreeSet<Integer> ts;

    public RecentCounter() {
        ts = new TreeSet<>();
    }

    public int ping(int t) {
        ts.add(t);
        return ts.tailSet(t - 3000).size();
    }
    */

    // Mehod 3: Binary Search ArrayList
    // Use binary search to find the index of the ceiling of t - 3000, then list.size() - index is the res
    // binarySearch() cost O(logN)
    /*
    List<Integer> list;

    public RecentCounter() {
        list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);
        int index = Collections.binarySearch(list, t - 3000); // search the index of t - 3000.
        if (index < 0) { index = -index - 1; } // if t - 3000 is not in list, use the index of the ceiling of t - 3000.
        return list.size() - index;
    }
    */
}

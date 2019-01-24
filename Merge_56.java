import java.util.*;

public class Merge_56 {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


    // My solution using union find (very slow)
    // Time: O(n^2)
    /*
    public List<Interval> merge(List<Interval> intervals) {
        int N = intervals.size();
        if (N <= 1) return intervals;
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
        for (int i = 0; i < N; i++) for (int j = i + 1; j < N; j++)
            if (overlap(intervals.get(i), intervals.get(j))) union(i, j, parent);
        HashMap<Integer, List<Interval>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int root = find(i, parent);
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(intervals.get(i));
        }
        List<Interval> res = new ArrayList<>();
        for (List<Interval> ls : map.values()) res.add(mergeOverlap(ls));
        return res;
    }

    private boolean overlap(Interval a, Interval b) {
        return a.start <= b.end && b.start <= a.end;
    }

    private Interval mergeOverlap(List<Interval> ls) {
        int start = ls.get(0).start;
        int end = ls.get(0).end;
        for (Interval i : ls) {
            start = Math.min(start, i.start);
            end = Math.max(end, i.end);
        }
        return new Interval(start, end);
    }

    private int find(int i, int[] parent) {
        if (i == parent[i]) return i;
        parent[i] = find(parent[i], parent);
        return parent[i];
    }

    private void union(int i, int j, int[] parent) {
        int pi = find(i, parent);
        int pj = find(j, parent);
        parent[pi] = pj;
    }
    */


    // My solution using sort
    // Time: O(n logn)

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        LinkedList<Interval> res = new LinkedList<>();
        Collections.sort(intervals, Comparator.comparing((Interval i) -> i.start));
        for (Interval i : intervals) {
            if (!res.isEmpty() && res.getLast().end >= i.start)
                res.getLast().end = Math.max(res.getLast().end, i.end);
            else res.add(i);
        }
        return res;
    }

}

import java.util.ArrayList;

class Interval_986 {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        ArrayList<Interval> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int l = Math.max(A[i].start, B[j].start);
            int r = Math.min(A[i].end, B[j].end);
            if (l <= r) res.add(new Interval(l ,r));
            if (A[i].end < B[j].end) i++;
            else j++;
        }
        return res.toArray(new Interval[res.size()]);
    }
}
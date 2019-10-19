import javafx.util.Pair;
import java.util.*;

class Employee_759 {
    // Rewrite standard solution #2: Priority Queue
    // Time: O(ClogN), where N is the number of employees, and C is the number of jobs across all employees.
    // The maximum size of the heap is N, so each push and pop operation is O(logN), and there are O(C) such operations.
    // Space: O(N)
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new LinkedList<>();
        PriorityQueue<Pair<Interval, Iterator<Interval>>> pq = new PriorityQueue<>((p1, p2) -> p1.getKey().start - p2.getKey().start);
        for (List<Interval> ls : schedule) {
            Iterator<Interval> it = ls.iterator();
            pq.add(new Pair<>(it.next(), it));
        }
        int anchor = -1;
        while (!pq.isEmpty()) {
            Pair<Interval, Iterator<Interval>> p = pq.poll();
            Interval i = p.getKey();
            Iterator<Interval> it = p.getValue();
            if (i.start > anchor) {
                res.add(new Interval(anchor, i.start));
            }
            anchor = Math.max(anchor, i.end);
            if (it.hasNext()) {
                pq.add(new Pair<>(it.next(), it));
            }
        }
        res.remove(0);
        return res;
    }



    // Rewrite standard solution #1: Sort all intervals
    // Time: O(ClogC), Space: O(C)
    /*
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new LinkedList<>();
        List<Interval> intervals = new ArrayList<>();
        for (List<Interval> ls : schedule) {
            intervals.addAll(ls);
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int anchor = -1;
        for (Interval i : intervals) {
            if (i.start > anchor) {
                res.add(new Interval(anchor, i.start));
            }
            anchor = Math.max(anchor, i.end);
        }
        res.remove(0);
        return res;
    }
    */
}
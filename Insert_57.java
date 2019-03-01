import java.util.List;
import java.util.ArrayList;

public class Insert_57 {
	class Interval {
		int start, end;
		Interval() {start = 0; end = 0;}
		Interval(int s, int e) {
			start = s;
			end = e;
		} 
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for (Interval i : intervals) {
            if (i.end < newInterval.start) {
                res.add(i);
            } else if (i.start > newInterval.end) {
                res.add(newInterval);
                newInterval = i;
            } else {
                int s = Math.min(i.start, newInterval.start);
                int e = Math.max(i.end, newInterval.end);
                newInterval = new Interval(s, e);
            }
        }
        res.add(newInterval);
        return res;
    }
}
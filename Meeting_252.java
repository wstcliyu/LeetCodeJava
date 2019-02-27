import java.util.Arrays;
import java.util.Comparator;

public class Meeting_252 {
	class Interval {
		int start, end;
	}
	public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparing((Interval i) -> i.start));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i+1].start) return false;
        }
        return true;
    }
}
import java.util.Arrays;
import java.util.Comparator;

class Non_435 {
    // My first solution (same as the most voted solution)
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.<int[]>comparingInt(interval -> interval[1]));
        int res = 0;
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] < end)
                res++;
            else
                end = interval[1];
        }
        return res;
    }
}
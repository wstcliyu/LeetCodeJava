import java.util.Arrays;
import java.util.List;

public class Minimum_539 {
    private int helper(String s) {
        String[] tmp = s.split(":");
        return Integer.valueOf(tmp[1]) + Integer.valueOf(tmp[0]) * 60;
    }

    // Most voted solution
    public int findMinDifference(List<String> timePoints) {
        int res = 720;
        int len = timePoints.size();
        boolean[] mark = new boolean[1440];
        for (int i=0; i<len; i++) {
            int time = helper(timePoints.get(i));
            if (mark[time])
                return 0;
            else
                mark[time] = true;
        }
        int prev = -720;
        int first = 720;
        for (int i=0; i<1440; i++) {
            if (mark[i]) {
                res = Math.min(res, i - prev);
                if (prev < 0)
                    first = i;
                prev = i;
            }
        }
        res = Math.min(res, first - prev + 1440);
        return res;
    }

    // Second voted solution
    /*
    public int findMinDifference(List<String> timePoints) {
        int res = 720;
        int len = timePoints.size();
        int[] time = new int[len];
        for (int i=0; i<len; i++)
            time[i] = helper(timePoints.get(i));
        Arrays.sort(time);
        for (int i=1; i<len; i++)
            res = Math.min(res, time[i] - time[i - 1]);
        res = Math.min(res, time[0] + 1440 - time[len - 1]);
        return res;
    }
    */
}

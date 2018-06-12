import java.util.Arrays;
import java.util.HashMap;

public class Most_826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<profit.length; i++)
            // There may exist two different works with the same difficulty
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i],0)));
        Arrays.sort(worker);
        Arrays.sort(difficulty);
        int res = 0, i = 0, best = 0;
        for (int skill:worker) {
            while (i<profit.length && skill>=difficulty[i])
                best = Math.max(best, map.get(difficulty[i++]));
            res += best;
        }
        return res;
    }
}
/* Standard solution
import java.awt.Point;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        Point[] jobs = new Point[N];
        for (int i = 0; i < N; ++i)
            jobs[i] = new Point(difficulty[i], profit[i]);
        Arrays.sort(jobs, (a, b) -> a.x - b.x);
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0;
        for (int skill: worker) {
            while (i < N && skill >= jobs[i].x)
                best = Math.max(best, jobs[i++].y);
            ans += best;
        }

        return ans;
    }
}
*/
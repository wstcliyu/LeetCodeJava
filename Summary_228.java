import java.util.ArrayList;
import java.util.List;

public class Summary_228 {
    // Merge intervals
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int N = nums.length;
        if (N == 0) return res;
        int start = nums[0], end = nums[0];
        for (int i = 1; i <= N; i++) {
            if (i < N && nums[i] == nums[i-1] + 1) end = nums[i];
            else {
                if (start == end) res.add(String.valueOf(start));
                else res.add(start + "->" + end);
                if (i < N) start = end = nums[i];
            }
        }
        return res;
    }
}

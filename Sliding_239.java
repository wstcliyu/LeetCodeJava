import java.util.LinkedList;

public class Sliding_239 {
    // Mono-queue
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int N = nums.length, anchor = 0;
        int[] res = new int[N - k + 1];
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            while (!q.isEmpty() && q.getFirst() <= i - k) q.removeFirst();
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) q.removeLast();
            q.add(i);
            if (i >= k - 1) res[anchor++] = nums[q.getFirst()];
        }
        return res;
    }


    // https://leetcode.com/problems/sliding-window-maximum/discuss/65881/O(n)-solution-in-Java-with-two-simple-pass-in-the-array
    // Two pass
    /*
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int N = nums.length;
        int[] res = new int[N - k + 1];
        int[] left_max = new int[N], right_max = new int[N];
        for (int i = 0, j = N - 1; i < N; i++, j--) {
            left_max[i] = (i % k == 0) ? nums[i] : Math.max(left_max[i - 1], nums[i]);
            right_max[j] = (j % k == 0 || j == N - 1) ? nums[j] : Math.max(right_max[j + 1], nums[j]);
        }
        for (int i = 0; i < res.length; i++)
            res[i] = Math.max(right_max[i], left_max[i + k - 1]);
        return res;
    }
    */
}

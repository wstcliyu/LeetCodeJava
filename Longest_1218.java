import java.util.HashMap;

class Longest_1218 {
    // Most voted solution: DP
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int res = 1;
        for (int a : arr) {
            int longest = 1 + dp.getOrDefault(a - difference, 0);
            dp.put(a, longest);
            res = Math.max(res, longest);
        }
        return res;
    }
}
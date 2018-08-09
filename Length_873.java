import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;

public class Length_873 {
    // Standard Solution Approach #1 Brutal Force with Set
    // Time: O(N^2 log M), where N is the length of A, and M is the maximum value of A.
    // Space: O(N)
    /*
    public int lenLongestFibSubseq(int[] A) {
        HashSet<Integer> nums = new HashSet<>();
        int res = 0;
        for (int a : A)
            nums.add(a);
        for (int i=0; i<A.length; i++) {
            for (int j=i+1; j<A.length; j++) {
                int tmp = 2, a = A[i], b = A[j];
                while (nums.contains(a + b)) {
                    b = a + b;
                    a = b - a;
                    tmp++;
                }
                res = Math.max(res, tmp);
            }
        }
        return res > 2 ? res : 0;
    }
    */


    // https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/discuss/152343/C++JavaPython-Check-Pair
    // Time: O(N^2)
    // Space: O(N^2)
    /*
    public int lenLongestFibSubseq(int[] A) {
        int res = 0;
        int[][] dp = new int[A.length][A.length];
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i=0; i<A.length; i++) {
            index.put(A[i], i);
            for (int j=0; j<i; j++) {
                int k = index.getOrDefault(A[i] - A[j], -1);
                dp[j][i] = (k < j && k >= 0) ? dp[k][j] + 1 : 2;
                res = Math.max(res, dp[j][i]);
            }
        }
        return res > 2 ? res : 0;
    }
    */


    // Standard Solution Approach #2 DP
    // https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/solution/
    // Time: O(N^2)
    // Space: O(N log M) or O(N^2) ?
    public static int lenLongestFibSubseq(int[] A) {
        int res = 0;
        HashMap<Integer, Integer> index = new HashMap<>();
        HashMap<Point, Integer> longest = new HashMap<>();
        for (int i=0; i<A.length; i++) {
            index.put(A[i], i);
            for (int j=0; j<i; j++) {
                int k = index.getOrDefault(A[i] - A[j], -1);
                if (k < j && k >= 0) {
                    int cand = 1 + longest.getOrDefault(new Point(k, j), 2);
                    longest.put(new Point(j, i), cand);
                    res = Math.max(res, cand);
                }
            }
        }
        return res > 2 ? res : 0;
    }

    public static void main(String[] args) {
        int[] testA = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(lenLongestFibSubseq(testA));
    }
}

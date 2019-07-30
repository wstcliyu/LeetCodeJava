import java.util.*;

// Some other ideas for this problem
// https://leetcode.com/problems/number-of-corner-rectangles/discuss/110200/Summary-of-three-solutions-based-on-three-different-ideas

class Number_750 {
    // Standard solution #1: Count Corners
    // Time: O(RC^2), Space: O(C^2)
    public int countCornerRectangles(int[][] grid) {
        Map<Integer, Integer> count = new HashMap();
        int ans = 0;
        for (int[] row: grid) {
            for (int c1 = 0; c1 < row.length; ++c1) if (row[c1] == 1) {
                for (int c2 = c1+1; c2 < row.length; ++c2) if (row[c2] == 1) {
                    int pos = c1 * 200 + c2;
                    int c = count.getOrDefault(pos, 0);
                    ans += c;
                    count.put(pos, c+1);
                }
            }
        }
        return ans;
    }




    // Most voted solution
    // Time: O(CR^2), Space: O(1)
    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        for (int r1 = 0; r1 < grid.length; r1++) {
            for (int r2 = r1 + 1; r2 < grid.length; r2++) {
                int count = 0;
                for (int c = 0; c < grid[0].length; c++) {
                    if (grid[r1][c] == 1 && grid[r2][c] == 1) count++;
                }
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }
}
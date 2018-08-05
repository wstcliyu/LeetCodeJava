public class Projection_887 {
    public int projectionArea(int[][] grid) {
        // Most voted solution
        // One pass, Time: O(n^2), Space: O(1)
        /*
        int z = 0, x = 0, y = 0;
        for (int i = 0; i < grid.length; ++i) {
            // mx denotes the maximum of the ith column
            // my denotes the maximum of the ith row
            int mx = 0, my = 0;
            for (int j = 0; j < grid.length; ++j) {
                mx = Math.max(mx, grid[j][i]); // grid[j][i]
                my = Math.max(my, grid[i][j]); // grid[i][j]
                if (grid[i][j] > 0)
                    z++;
            }
            x += mx;
            y += my;
        }
        return x + y + z;
        */

        // My solution
        // Time: O(n^2), Space: O(n)
        int len = grid.length;
        int bottom = 0, res = 0;
        int[] rowMax = new int[len];
        int[] colMax = new int[len];
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                bottom += grid[i][j]>0 ? 1 : 0;
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        for (int r : rowMax)
            res += r;
        for (int c : colMax)
            res += c;
        return res + bottom;
    }
}

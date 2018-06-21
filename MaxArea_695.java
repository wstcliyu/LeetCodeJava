public class MaxArea_695 {
    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++)
                res = Math.max(res, helper(grid, i, j));
        }
        return res;
    }
    private static int helper(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return 0;
        if (grid[x][y] == 0)
            return 0;
        grid[x][y] = 0;
        return 1 + helper(grid, x+1, y) + helper(grid, x-1, y) + helper(grid, x, y+1) + helper(grid, x, y-1);
    }
    public static void main (String[] args) {
        int[][] testGrid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                            {0,0,0,0,0,0,0,1,1,1,0,0,0},
                            {0,1,1,0,1,0,0,0,0,0,0,0,0},
                            {0,1,0,0,1,1,0,0,1,0,1,0,0},
                            {0,1,0,0,1,1,0,0,1,1,1,0,0},
                            {0,0,0,0,0,0,0,0,0,0,1,0,0},
                            {0,0,0,0,0,0,0,1,1,1,0,0,0},
                            {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(testGrid));
    }
}

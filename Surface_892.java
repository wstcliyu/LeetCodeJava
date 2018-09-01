public class Surface_892 {
    // My first solution, which is a wrong solution
    // I ignore the surface area that may be surrounded by other cubes
    /*
    public int surfaceArea(int[][] grid) {
        int N = grid.length;
        int area = 0;
        for (int i=0; i<N; i++) {
            int maxRow = 0, maxCol = 0;
            for (int j=0; j<N; j++) {
                area += grid[i][j] == 0 ? 0 : 1;
                maxRow = Math.max(grid[i][j], maxRow);
                maxCol = Math.max(grid[j][i], maxCol);
            }
            area += maxRow + maxCol;
        }
        return 2 * area;
    }
    */


    // Standard solution
    public int surfaceArea(int[][] grid) {
        int N = grid.length;
        int area = 0;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (grid[i][j] > 0) {
                    area += 2;
                    for (int k=0; k<4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        // Note this step. It cannot be simplified because there is no neighborhood in the corner or side.
                        int nv = 0;
                        if (nr >=0 && nr < N && nc >= 0 && nc < N)
                            nv = grid[nr][nc];
                        area += Math.max(0, grid[i][j] - nv);
                    }
                }
            }
        }
        return area;
    }
}

public class Island_463 {
    public static int islandPerimeter(int[][] grid) {
        /* Most voted solution
         * Only count neighbors to the right and down side, so it won't repeat counting
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }
        return islands * 4 - neighbours * 2;
        */
        int r = grid.length;
        int l = grid[0].length;
        int perimeter = 0;
        for (int x=0; x<r; x++) {
            for (int y=0; y<l; y++) {
                if (grid[x][y] > 0) {
                    perimeter += grid[x][y] * 4;
                    if (thereIsLand(x - 1, y, grid))
                        perimeter--;
                    if (thereIsLand(x + 1, y, grid))
                        perimeter--;
                    if (thereIsLand(x, y - 1, grid))
                        perimeter--;
                    if (thereIsLand(x, y + 1, grid))
                        perimeter--;
                }
            }
        }
        return perimeter;
    }
    private static boolean thereIsLand(int x, int y, int[][] grid) {
        int r = grid.length;
        int l = grid[0].length;
        if (x>=0 && x<r && y>=0 && y<l)
            return grid[x][y]>0;
        return false;
    }
    public static void main (String args[]) {
        int[][] testGrid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(testGrid));
    }
}

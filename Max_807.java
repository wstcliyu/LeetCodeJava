public class Max_807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int res = 0;
        int N = grid.length;
        int[] row = new int[N], col = new int[N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[i] = Math.max(col[i], grid[j][i]);
            }
        }
        for (int i=0; i<N; i++)
            for (int j=0; j<N; j++)
                res += Math.min(row[i], col[j]) - grid[i][j];
        return res;
    }
}

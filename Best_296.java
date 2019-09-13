import java.util.ArrayList;
import java.util.List;

class Best_296 {
    private List<Integer> collectRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1)
                    rows.add(r);
            }
        }
        return rows;
    }
    
    private List<Integer> collectCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for (int c = 0; c < grid[0].length; c++) {
            for (int r = 0; r < grid.length; r++) {
                if (grid[r][c] == 1)
                    cols.add(c);
            }
        }
        return cols;
    }
    
    private int minDistance1D(List<Integer> ls) {
        // Use median
        // int origin = ls.get(ls.size() / 2);
        // int distance = 0;
        // for (int x : ls) distance += Math.abs(x - origin);
        // return distance;

        int i = 0, j = ls.size() - 1;
        int distance = 0;
        while (i < j) {
            distance += ls.get(j--) - ls.get(i++);
        }
        return distance;
    }
    
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        return minDistance1D(rows) + minDistance1D(cols);
    }
}
import java.util.*;

public class Number_694 {
    // Standard solution #1: Hash By Local Coordinates
    /*
    int[][] grid;
    boolean[][] seen;
    Set<Integer> shape;

    public void explore(int r, int c, int r0, int c0) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
                grid[r][c] == 1 && !seen[r][c]) {
            seen[r][c] = true;
            // We must use a number greater than or equal to 2 * grid[0].length
            // Because the lower digit (which records the difference of columns)
            // ranges from -grid[0].length+1 to grid[0].length-1
            shape.add((r - r0) * 2 * grid[0].length + (c - c0));
            explore(r+1, c, r0, c0);
            explore(r-1, c, r0, c0);
            explore(r, c+1, r0, c0);
            explore(r, c-1, r0, c0);
        }
    }
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        Set<Set<Integer>> shapes = new HashSet<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                shape = new HashSet<Integer>();
                explore(r, c, r, c);
                if (!shape.isEmpty()) shapes.add(shape);
            }
        }

        return shapes.size();
    }
    */



    // Standard solution #2: Hash By Path Signature
    int[][] grid;
    boolean[][] seen;
    ArrayList<Integer> shape;

    public void explore(int r, int c, int di) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
                grid[r][c] == 1 && !seen[r][c]) {
            seen[r][c] = true;
            shape.add(di);
            explore(r+1, c, 1);
            explore(r-1, c, 2);
            explore(r, c+1, 3);
            explore(r, c-1, 4);
            // Keep in mind to record both when we enter and when we exit the function
            shape.add(0);
        }
    }
    public int numDistinctIslands(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        Set<List<Integer>> shapes = new HashSet<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                shape = new ArrayList<Integer>();
                explore(r, c, 0);
                if (!shape.isEmpty()) shapes.add(shape);

            }
        }
        return shapes.size();
    }

}

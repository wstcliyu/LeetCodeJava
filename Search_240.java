public class Search_240 {
    // Most voted solution
    // Time: O(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int x = 0, y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] > target)
                y--;
            else
                x++;
        }
        return false;
    }
}

public class Max_Min_Path {
    // Amazon OA 2: Maximum Minimum Path
    // Given an integer matrix, a path is from top-left to botton-right
    // (You can only go down or right)
    /*
    [8, 4, 7]
    [6, 5, 9]
    There are three paths
    8-4-7-9 min: 4
    8-4-5-9 min: 4
    8-6-5-9 min: 5
    return: 5
     */


    // DP
    public int maxMinPath(int[][] matrix){
        int row = matrix.length, col = matrix[0].length;
        int[] res = new int[col];
        res[0] = matrix[0][0];
        for(int i = 1; i < col; i++) res[i] = Math.min(res[i - 1], matrix[0][i]);
        for(int i = 1; i < row; i++) {
            res[0] = Math.min(matrix[i][0], res[0]);
            for(int j = 1; j < col; j++)
                res[j] = (matrix[i][j] > res[j] && matrix[i][j] > res[j - 1]) ?
                        Math.max(res[j - 1], res[j]) : matrix[i][j];
        }
        return res[col - 1];
    }


    // Recursion using DFS
    /*
    private int max;

    public int maxMinPath(int[][] matrix) {
        max = Integer.MIN_VALUE;
        dfsHelper(matrix, Integer.MAX_VALUE, 0, 0);
        return max;
    }

    public void dfsHelper(int[][] matrix, int pathMin, int i, int j ){
        int row = matrix.length, col = matrix[0].length;
        if (i >= row || j >= col) return;
        pathMin = Math.min(pathMin, matrix[i][j]);
        if (i == row - 1 && j == col - 1) max = Math.max(max, pathMin);
        dfsHelper(matrix, pathMin, i, j + 1);
        dfsHelper(matrix, pathMin, i + 1, j);
    }
    */
}

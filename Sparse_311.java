import java.util.*;

class Sparse_311 {
    // My first solution
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        List<List<Integer>> rowA = new ArrayList<>();
        List<List<Integer>> rowB = new ArrayList<>();
        recordNonZeroValues(rowA, A);
        recordNonZeroValues(rowB, B);
        for (int i = 0; i < A.length; i++) {
            for (int c : rowA.get(i)) {
                for (int j : rowB.get(c)) {
                    res[i][j] += A[i][c] * B[c][j];
                }
            }
        }
        return res;
    }
    
    private void recordNonZeroValues(List<List<Integer>> rows, int[][] M) {
        int R = M.length;
        int C = M[0].length;
        for (int i = 0; i < R; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < C; j++) {
                if (M[i][j] != 0) {
                    row.add(j);
                }
            }
            rows.add(row);
        }
    }
}
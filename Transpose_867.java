public class Transpose_867 {
    public int[][] transpose(int[][] A) {
        int r = A.length, c = A[0].length;
        int[][] res = new int[c][r];
        for (int i=0; i<c; i++) {
            for (int j=0; j<r; j++)
                res[i][j] = A[j][i];
        }
        return res;
    }
}

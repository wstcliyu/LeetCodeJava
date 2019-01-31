public class Squares_977 {
    public int[] sortedSquares(int[] A) {
        int i = 0, j = A.length - 1, end = j;
        int[] res = new int[A.length];
        while (end >= 0) {
            int ii = A[i] * A[i], jj = A[j] * A[j];
            if (ii > jj) {
                res[end--] = ii;
                i++;
            } else {
                res[end--] = jj;
                j--;
            }
        }
        return res;
    }
}

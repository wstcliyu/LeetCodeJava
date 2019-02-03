public class Sum_985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int a : A) if (a % 2 == 0) sum += a;
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][1];
            if (A[idx] % 2 == 0) sum -= A[idx];
            A[idx] += queries[i][0];
            if (A[idx] % 2 == 0) sum += A[idx];
            res[i] = sum;
        }
        return res;
    }
}

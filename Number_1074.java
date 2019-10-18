import java.util.HashMap;

class Number_1074 {
    // My first solution: similar to most voted solution from lee215
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] colSum = new int[R + 1][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                colSum[i + 1][j] = colSum[i][j] + matrix[i][j];
            }
        }
        
        int res = 0;
        for (int a = 0; a < R; a++) {
            for (int b = a + 1; b <= R; b++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;
                for (int j = 0; j < C; j++) {
                    sum += colSum[b][j] - colSum[a][j];
                    res += map.getOrDefault(sum - target, 0);
                    map.put(sum, 1 + map.getOrDefault(sum, 0));
                }
            }
        }
        return res;
    }
}
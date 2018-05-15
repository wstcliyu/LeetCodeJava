public class Range_598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0)
            return m*n;
        int minA = 40000, minB = 40000;
        for (int[] op:ops) {
            minA = Math.min(minA,op[0]);
            minB = Math.min(minB,op[1]);
        }
        return minA*minB;
    }
}

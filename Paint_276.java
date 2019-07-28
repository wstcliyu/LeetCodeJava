class Paint_276 {
    // My first solution: DP
    // same denotes the number of paint ways with last two of the same color
    // diff denotes the number of paint ways with last two of different color
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        int same = 0;
        int diff = k;
        for (int i = 1; i < n; i++) {
            int tmp = diff;
            diff = (diff + same) * (k - 1);
            same = tmp;
        }
        return same + diff;
    }
}
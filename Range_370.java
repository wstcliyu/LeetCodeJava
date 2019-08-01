class Range_370 {
    // Standard solution #2: Range Caching
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int incr = update[2];
            res[start] += incr;
            if (end + 1 < length)
                res[end + 1] -= incr;
        }
        
        for (int i = 1; i < length; i++)
            res[i] += res[i - 1];
        return res;
    }
}
class Maximum_1186 {
    // Most voted solution: left and right array
    public int maximumSum(int[] a) {
        int N = a.length;
        int[] maxEndHere = new int[N];
        int[] maxStartHere = new int[N];
        maxEndHere[0] = a[0];
        maxStartHere[N - 1] = a[N - 1];
        int res = a[0];
        for (int i = 1, j = N - 2; i < N; i++, j--) {
            maxEndHere[i] = a[i] + Math.max(0, maxEndHere[i - 1]);
            maxStartHere[j] = a[j] + Math.max(0, maxStartHere[j + 1]);
            res = Math.max(res, maxEndHere[i]);
        }
        for (int i = 1; i < N - 1; i++)
            res = Math.max(res, maxEndHere[i - 1] + maxStartHere[i + 1]);
        return res;
    }
}
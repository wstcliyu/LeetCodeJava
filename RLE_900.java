public class RLE_900 {
    // Keep track of an index
    private int idx = 0;
    private int[] A;

    public RLE_900(int[] A) {this.A = A;}

    public int next(int n) {
        while (idx < A.length && A[idx] < n) {
            n -= A[idx];
            idx += 2;
        }
        if (idx >= A.length) return -1;
        A[idx] -= n;
        return A[idx + 1];
    }

    // My first solution (It gets wrong answer if the values get large to exceed the limit of int)
    /*
    private int[] freq, nums;
    private int count, size;

    public RLE_900(int[] A) {
        int n = A.length;
        freq = new int[n / 2];
        nums = new int[n / 2];
        count = 0;
        size = 0;
        for (int i = 0; i < n; i += 2) {
            size += A[i];
            freq[i / 2] = size;
            nums[i / 2] = A[i + 1];
        }
    }

    public int next(int n) {
        count += n;
        if (count > size) return -1;
        int p = binarySearch(freq, count);
        return nums[p];
    }

    private int binarySearch(int[] freq, int count) {
        int l = 0, r = freq.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (freq[m] < count) l = m + 1;
            else r = m;
        }
        return r;
    }
    */
}

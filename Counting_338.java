public class Counting_338 {
    // My solution
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i=0; i<=num; i++)
            res[i] = Integer.bitCount(i); // res[i] = res[i&(i-1)] + 1;
        return res;
    }

    // Most voted solution
    // An easy recurrence for this problem is f[i] = f[i / 2] + i % 2
    /*
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++)
            f[i] = f[i >> 1] + (i & 1);
        return f;
    }
    */
}

public class Binary_868 {
    public int binaryGap(int N) {
        int res = 0, prev = -1;
        for (int i=0; i<32; i++) {
            if ((N & (1 << i)) != 0) {
                if (prev >= 0)
                    res = Math.max(res, i - prev);
                prev = i;
            }
        }
        return res;
    }
}

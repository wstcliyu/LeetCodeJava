import java.util.Arrays;
import java.util.Random;

public class Random_528 {
    // https://leetcode.com/problems/random-pick-with-weight/discuss/154044/Java-accumulated-freq-sum-and-binary-search
    // Most voted solution

    Random random;
    int[] wSum;

    public Solution(int[] w) {
        random = new Random();
        wSum = new int[w.length];
        wSum[0] = w[0];
        for (int i=1; i<w.length; i++)
            wSum[i] = wSum[i-1] + w[i];
    }

    public int pickIndex() {
        int len = wSum.length;
        int val = random.nextInt(wSum[len-1]) + 1;
        int res = Arrays.binarySearch(wSum, val);
        return res<0 ? -res-1 : res;
    }
}

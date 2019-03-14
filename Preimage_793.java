public class Preimage_793 {
    // https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/discuss/117821/Four-binary-search-solutions-based-on-different-ideas
    // The link above gives out 4 solutions
    // My first solution is the same as the first one
    public int preimageSizeFZF(int K) {
        return (int)(getRightMost(K) - getRightMost(K-1));
    }
    
    private long countTrailingZero(long n) {
        long count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
    
    private long getRightMost(int K) {
        long l = 0, r = Long.MAX_VALUE;
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (countTrailingZero(mid) <= K)
                l = mid + 1;
            else
                r = mid;
        }
        return r - 1;
    }
}
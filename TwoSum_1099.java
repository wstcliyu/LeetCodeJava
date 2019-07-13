import java.util.Arrays;

class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int res = -1;
        Arrays.sort(A);
        int i = 0, j = A.length - 1;
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum > res && sum < K) {
                res = sum;
            }
            if (sum >= K) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}
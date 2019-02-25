public class Longest_978 {
    public int maxTurbulenceSize(int[] A) {
        int res = 1, dp = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) dp = 1;
            else if (i > 1 && Integer.compare(A[i], A[i - 1]) * Integer.compare(A[i - 1], A[i - 2]) < 0) dp++;
            else dp = 2;
            res = Math.max(res, dp);
        }
        return res;
    }
}

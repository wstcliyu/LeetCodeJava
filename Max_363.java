import java.util.TreeSet;

public class Max_363 {
    // Most voted solution using TreeSet
    // Time: O(m^2 nlgn)
    // Space: O(n)
    // m = Math.min(R, C), n = Math.max(R, C)
	public int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        int R = matrix.length, C = matrix[0].length;
        int m = Math.min(R, C), n = Math.max(R, C);
        boolean rowIsLarger = R > C;
        for (int l = 0; l < m; l++) {
            int[] sum = new int[n];
            for (int r = l; r < m; r++) {
                for (int i = 0; i < n; i++)
                    sum[i] += rowIsLarger ? matrix[i][r] : matrix[r][i];
                res = Math.max(res, helper(sum, k));
            }
        }
        return res;
    }
    
    private int helper(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int sum = 0, res = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            Integer tmp = set.ceiling(sum - k);
            if (tmp != null) res = Math.max(res, sum - tmp);
            set.add(sum);
        }
        return res;
    }




    // A good idea using merge sort
    // https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/83595/JAVA-117ms-beat-99.81-merge-sort
    /*
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, ans = Integer.MIN_VALUE;
        long[] sum = new long[m+1]; // stores sum of rect[0..p][i..j]
        for (int i = 0; i < n; ++i) {
            long[] sumInRow = new long[m];
            for (int j = i; j < n; ++j) { // for each rect[*][i..j]
                for (int p = 0; p < m; ++p) {
                    sumInRow[p] += matrix[p][j];
                    sum[p+1] = sum[p] + sumInRow[p];
                }
                ans = Math.max(ans, mergeSort(sum, 0, m+1, k));
                if (ans == k) return k;
            }
        }
        return ans;
    }

    int mergeSort(long[] sum, int start, int end, int k) {
        if (end == start+1) return Integer.MIN_VALUE; // need at least 2 to proceed
        int mid = start + (end - start)/2, cnt = 0;
        int ans = mergeSort(sum, start, mid, k);
        if (ans == k) return k;
        ans = Math.max(ans, mergeSort(sum, mid, end, k));
        if (ans == k) return k;
        long[] cache = new long[end-start];
        for (int i = start, j = mid, p = mid; i < mid; ++i) {
            while (j < end && sum[j] - sum[i] <= k) ++j;
            if (j-1 >= mid) {
                ans = Math.max(ans, (int)(sum[j-1] - sum[i]));
                if (ans == k) return k;
            }
            while (p < end && sum[p] < sum[i]) cache[cnt++] = sum[p++];
            cache[cnt++] = sum[i];
        }
        System.arraycopy(cache, 0, sum, start, cnt);
        return ans;
    }
    */
}
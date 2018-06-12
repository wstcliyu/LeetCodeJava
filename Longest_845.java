public class Longest_845 {
    public static int longestMountain(int[] A) {
        /* Most voted solution
        int res = 0, up = 0, down = 0;
        for (int i = 1; i < A.length; ++i) {
            if (down > 0 && A[i - 1] < A[i] || A[i - 1] == A[i]) up = down = 0;
            if (A[i - 1] < A[i]) up++;
            if (A[i - 1] > A[i]) down++;
            if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
        }
        return res;
        */
        int res = 0, left = 0, right;
        while (left < A.length-2) {
            if (A[left] == A[left+1]) {
                left++;
                continue;
            }
            right = left;
            while (right < A.length-1) {
                if (A[right] < A[right+1])
                    right++;
                else
                    break;
            }
            int mid = right;
            while (right < A.length-1) {
                if (A[right] > A[right+1])
                    right++;
                else
                    break;
            }
            if (mid > left && mid < right)
                res = Math.max(res, right-left+1);
            left = right;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] testA = {2,2,2};
        System.out.println(longestMountain(testA));
    }
}

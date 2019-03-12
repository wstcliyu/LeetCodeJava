public class Minimum_1007 {
	// Most voted solution
	// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/discuss/252242/JavaPython-Find-Intersection-of-Dominos
	// Solution #2: Try A[0] or B[0]
	public int minDominoRotations(int[] A, int[] B) {
        int x = helper(A, B, A[0]);
        int y = helper(A, B, B[0]);
        int res = Math.min(x, y);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    private int helper(int[] A, int[] B, int val) {
        int a = 0, b = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != val && B[i] != val)
                return Integer.MAX_VALUE;
            if (A[i] != val) a++;
            if (B[i] != val) b++;
        }
        return Math.min(a, b);
    }
}
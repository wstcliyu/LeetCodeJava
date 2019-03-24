public class Best_1021 {
	// My solution
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int best = A[0];
        for (int j = 1; j < A.length; j++) {
            res = Math.best(res, best + A[j] - j);
            best = Math.best(best, A[j] + j);
        }
        return res;
	}



	// Most voted solution
	/*
	public int maxScoreSightseeingPair(int[] A) {
        int res = 0, cur = 0;
        for (int a: A) {
            res = Math.max(res, cur + a);
            cur = Math.max(cur, a) - 1;
        }
        return res;
    }
    */
}
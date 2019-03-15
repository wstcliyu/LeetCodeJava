public class BinarySearch {

	// Loop invariant:
	// l = 0 || A[l-1] <= target
	// r = A.length || A[r] > target
	// result in [-1, A.length-1]
	public int floorIdx(int[] A, int target) {
		int l = 0;
		int r = A.length;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (A[m] <= target)
				l = m + 1;
			else
				r = m;
		}
		return l - 1;
	}


	// Loop invariant:
	// l = 0 || A[l-1] < target
	// r = A.length || A[r] >= target
	// result in [0, A.length]
	public int ceilIdx(int[] A, int target) {
		int l = 0;
		int r = A.length;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (A[m] < target)
				l = m + 1;
			else
				r = m;
		}
		return l;
	}
}
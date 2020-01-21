import java.util.Arrays;
import java.util.List;

class Element_1287 {
    // Most voted solution: Binary Search for only 3 candidates
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        List<Integer> candidates = Arrays.asList(arr[n/4], arr[n/2], arr[3*n/4]);
        for (int candidate : candidates) {
            int leftInclusive = myBinarySearch(arr, candidate);
            int rightExclusive = myBinarySearch(arr, candidate + 1);
            if (rightExclusive - leftInclusive > n/4) return candidate;
        }
        return -1;
    }
    
    private int myBinarySearch(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}
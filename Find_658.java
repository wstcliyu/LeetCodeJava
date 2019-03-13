import java.util.List;
import java.util.ArrayList;

class Find_658 {
    // Most voted solution
    // Imagine we are trying to find a window with k elements
    // A[start] ~ A[start + k - 1]
    // We only need to find the start of the window
    // Time: O(lg(N-K) + K)
    /*
    public List<Integer> findClosestElements(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x) 
            // It means A[mid] is farther from x than A[mid + k], so we should not include A[mid] in our result
                left = mid + 1;
            else 
            // It means A[mid + k] should not be included in our result, so our start should <= mid
                right = mid;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) res.add(A[left + i]);
        return res;
    }
    */



    // My solution using binary search
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = Integer.MAX_VALUE;
        int[] num;
        while (l < r) {
            int mid = l + (r - l) / 2;
            num = numInRad(arr, x, mid);
            if (num[1] - num[0] + 1 < k)
                l = mid + 1;
            else
                r = mid;
        }
        num = numInRad(arr, x, r);
        int start = num[0], end = num[1];
        while (end - start + 1 > k) {
            if (Math.abs(x - arr[end]) >= Math.abs(x - arr[start]))
                end--;
            else
                start++;
        }
        
        List<Integer> res = new ArrayList<>(k);
        for (int i = start; i <= end; i++)
            res.add(arr[i]);
        
        return res;
    }
    
    private int[] numInRad(int[] arr, int x, int radius) {
        int p1 = myBinarySearchLeft(arr, x - radius);
        int p2 = myBinarySearchRight(arr, x + radius);
        return new int[]{p1, p2};
    }
    
    private int myBinarySearchLeft(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }
    
    private int myBinarySearchRight(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return r - 1;
    }
}
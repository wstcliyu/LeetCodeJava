import java.util.PriorityQueue;
import java.util.Random;

public class Kth_215 {
    // Quick Select
    public int findKthLargest(int[] a, int k) {
        // shuffle(a);
        int n = a.length;
        int p = quickSelect(a, 0, n - 1, k);
        return a[p];
    }

    private int quickSelect(int[] a, int lo, int hi, int k) {
        int i = lo, j = hi;

        // My version
        // put nums that are < pivot to the left
        // put nums that are >= pivot to the right
        // Use a random pivot and do not need to shuffle the whole array
        
        swap(a, j, new Random().nextInt(j-i+1) + i);
        int pivot = a[hi];
        while (i < j) {
            while (i < j && a[i] < pivot) i++;
            while (i < j && a[j] >= pivot) j--;
            swap(a, i, j);
        }
        swap(a, i, hi);
        
        int m = hi - i + 1;
        if (m == k)     return i;
        else if (m > k) return quickSelect(a, i + 1, hi, k);
        else            return quickSelect(a, lo, i - 1, k - m);

        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        /*
        int pivot = a[hi];
        while (i < j) {
            if (a[i++] > pivot) swap(a, --i, --j);
        }
        swap(a, i, hi);

        // count the nums that are <= pivot from lo
        int m = i - lo + 1;

        // pivot is the one!
        if (m == k)     return i;
        // pivot is too big, so it must be on the left
        else if (m > k) return quickSelect(a, lo, i - 1, k);
        // pivot is too small, so it must be on the right
        else            return quickSelect(a, i + 1, hi, k - m);
        */
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void shuffle(int[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++)
            swap(a, i, random.nextInt(i + 1));
    }



    // Template for quickSort and quickSelect
    /*
    private void quickSort(int[] A, int left, int right) {
        if (left >= right) return;
        int i = quickSelect(A, left, right);
        quickSort(A, left, i - 1);
        quickSort(A, i + 1, right);
    }
    
    private int quickSelect(int[] A, int left, int right) {
        swap(A, right, left + new Random().nextInt(right - left + 1));
        int pivot = A[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (A[j] < pivot) swap(A, i++, j);
        }
        swap(A, i, right);
        return i;
    }
    */



    // Min Heap
    // Time: O(n lgk)
    /*
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        return heap.peek();
    }
    */
}

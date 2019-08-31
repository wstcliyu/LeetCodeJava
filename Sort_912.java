class Sort_912 {
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    // Bubble Sort
    /*
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) swap(nums, j, j + 1);
            }
        }
        return nums;
    }
    */



    // Insertion Sort
    /*
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            for (; j >= 0 && nums[j] > key; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = key;
        }
        return nums;
    }
    */



    // Selection Sort
    /*
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i; j < n; j++) {
                if (nums[j] < nums[min_idx]) min_idx = j;
            }
            swap(nums, i, min_idx);
        }
        return nums;
    }
    */



    // Quick Sort
    /*
    private int quickSelect(int[] A, int lo, int hi) {
        int pivot = lo + new java.util.Random().nextInt(hi - lo + 1);
        swap(A, hi, pivot);
        int i = lo;
        for (int j = lo; j <= hi; j++)
            if (A[j] < A[hi])
                swap(A, i++, j);
        swap(A, i, hi);
        return i;
    }
    
    private void quickSort(int[] A, int lo, int hi) {
        if (lo < hi) {
            int p = quickSelect(A, lo, hi);
            quickSort(A, lo, p - 1);
            quickSort(A, p + 1, hi);
        }
    }
    
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        return nums;
    }
    */



    
}
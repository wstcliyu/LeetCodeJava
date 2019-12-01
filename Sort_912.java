class Sort_912 {
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }


    // Heap Sort
    public int[] sortArray(int[] nums) {
        buildMaxHeap(nums);
        heapSort(nums);
        return nums;
    }

    private void maxheapify(int[] nums, int i, int size) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && nums[l] > nums[largest]) largest = l;
        if (r < size && nums[r] > nums[largest]) largest = r;
        if (largest != i) {
            swap(nums, i, largest);
            maxheapify(nums, largest, size);
        }
    }

    private void buildMaxHeap(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            maxheapify(nums, i, n);
        }
    }

    private void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            maxheapify(nums, 0, i);
        }
    }



    // Merge Sort
    /*
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo == hi) return;
        int m = (lo + hi) / 2;
        mergeSort(nums, lo, m);
        mergeSort(nums, m + 1, hi);
        merge(nums, lo, m, m + 1, hi);
    }
    
    private void merge(int[] nums, int lo1, int hi1, int lo2, int hi2) {
        int start = lo1;
        int end = hi2;
        int[] tmp = new int[end - start + 1];
        int i = 0;
        while (lo1 <= hi1 && lo2 <= hi2) {
            tmp[i++] = nums[lo1] < nums[lo2] ? nums[lo1++] : nums[lo2++];
        }
        while (lo1 <= hi1) {
            tmp[i++] = nums[lo1++];
        }
        while (lo2 <= hi2) {
            tmp[i++] = nums[lo2++];
        }
        for (int j = start, k = 0; j <= end; j++, k++) {
            nums[j] = tmp[k];
        }
    }
    */


    
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
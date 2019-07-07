class Duplicate_1089 {
    // My first solution
    /*
    public void duplicateZeros(int[] arr) {
        Deque<Integer> buffer = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            buffer.addLast(arr[i]);
            arr[i] = buffer.removeFirst();
            if (arr[i] == 0 && i + 1 < arr.length) {
                buffer.addLast(arr[++i]);
                arr[i] = 0;
            }
        }
    }
    */


    // Most voted solution
    public void duplicateZeros(int[] arr) {
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) countZero++;
        }
        int len = arr.length + countZero;
        //We just need O(1) space if we scan from back
        //i point to the original array, j point to the new location
        for (int i = arr.length - 1, j = len - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) arr[j] = arr[i];
            } else {
                if (j < arr.length) arr[j] = arr[i];
                j--;
                if (j < arr.length) arr[j] = arr[i]; //copy twice when hit '0'
            }
        }

	// Another version
	/*
	for (int i = n - 1; i >= 0; --i) {
            if (--j < n)
                A[j] = A[i];
            if (A[i] == 0 && --j < n)
                A[j] = 0;
        }
	*/
    }
}

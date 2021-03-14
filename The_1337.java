class The_1337 {
    // My first solution
    // Similar to Approach 4: Binary Search and Priority Queue
    // Time: O(mlognk), Space: O(k)
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing((Integer i) -> -myBinarySearch(mat[i])).thenComparing(i -> -i));
        for (int i = 0; i < mat.length; i++) {
            pq.add(i);
            if (pq.size() > k) pq.poll();
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }
    
    private int myBinarySearch(int[] row) {
        int l = 0, r = row.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (row[m] == 1) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
  
  
  
    // Approach 5: Vertical Iteration
    // Time: O(mn), Space: O(1)
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[] indexes = new int[k];
        int nextInsertIndex = 0;

        // This code does the same as the animation above.
        for (int c = 0; c < n && nextInsertIndex < k; c++) {
            for (int r = 0; r < m && nextInsertIndex < k; r++) {
                // If this is the first 0 in the current row.
                if (mat[r][c] == 0 && (c == 0 || mat[r][c - 1] == 1)) {
                    indexes[nextInsertIndex] = r;
                    nextInsertIndex++;
                }
            }
        }

        /* If there aren't enough, it's because some of the first k weakest rows
         * are entirely 1's. We need to include the ones with the lowest indexes
         * until we have at least k. */
        for (int r = 0; nextInsertIndex < k ; r++) {
            /* If index i in the last column is 1, this was a full row and therefore
             * couldn't have been included in the output yet. */
            if (mat[r][n - 1] == 1) {
                indexes[nextInsertIndex] = r;
                nextInsertIndex++;
            }
        }

        return indexes;
    }
}

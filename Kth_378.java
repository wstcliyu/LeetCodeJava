import java.util.PriorityQueue;

public class Kth_378 {
    // https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378

    // III -- PriorityQueue-based solution with optimization
    // Time: O(max(n, k) * lgn), Space: O(n)
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) { // (a[0], a[1]) and (b[0], b[1]) are positions in the matrix
                return Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]);
            }
        });
        
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {i, 0});  // initialize the pool with elements from the first column
        }
        
        while (--k > 0) {                // remove the smallest elements from the matrix (k-1) times
            int[] p = pq.poll();
            
            if (++p[1] < n) {
                pq.offer(p);             // add the next element in the same row if it exists
            }
        }
        
        return matrix[pq.peek()[0]][pq.peek()[1]];
    }




    // IV -- BinarySearch-based solution
    // Time: O(n * lg(MAX- MIN)), Space: O(1)
    /*
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        int l = matrix[0][0];               // minimum element in the matrix
        int r = matrix[n - 1][n - 1];       // maximum element in the matrix
        
        for (int cnt = 0; l < r; cnt = 0) { // this is the binary search loop
            int m = l + (r - l) / 2;
            
            for(int i = 0, j = n - 1; i < n; i++)  {
                while (j >= 0 && matrix[i][j] > m) j--;  // the pointer j will only go in one direction
                cnt += (j + 1);
            }
            
            if (cnt < k) {
                l = m + 1;   // cnt less than k, so throw away left half
            } else {
                r = m;       // otherwise discard right half
            }
        }
        
        return l;
    }
    */




    // V -- ZigzagSearch-based solution
    // Time: O(n^2), Space: O(1)
    /*
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        int row = 0;          // we start from the upper-right corner
        int col = n - 1;      
        
        for (int cnt_le = 0, cnt_lt = 0; true; cnt_le = 0, cnt_lt = 0) {
            for (int i = 0, j = n - 1, p = n - 1; i < n; i++) {
                while (j >= 0 && matrix[i][j] > matrix[row][col]) j--;    // pointer j for counting cnt_le
                cnt_le += (j + 1);
                
                while (p >= 0 && matrix[i][p] >= matrix[row][col]) p--;   // pointer p for counting cnt_lt
                cnt_lt += (p + 1);
            }
            
            if (cnt_le < k) {         // candidate solution too small so increase it
                row++; 
            } else if (cnt_lt >= k) { // candidate solution too large so decrease it
                col--;
            } else {                  // candidate solution equal to the kth smallest element so return
                return matrix[row][col];
            }
        }
    }
    */




    // Most voted solution
    // Binary Search
    /*
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    */



    // Heap
    /*
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for(int j = 0; j <= n - 1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if(t.x == n - 1) continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.peek().val;
    }


    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo (Tuple that) {
            return this.val - that.val;
        }
    }
    */
}

import java.util.PriorityQueue;
import java.util.Comparator;

class Kth_786 {
    // https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378

    // SOLUTION ONE -- Using PriorityQueue with optimization
    // Time: O((n + K) * logn), Space: O(n)
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(A[a[0]] * A[n - 1 - b[1]], A[n - 1 - a[1]] * A[b[0]]);
            }
        });
        
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {i, 0});
        }
        
        while (--K > 0) {
            int[] p = pq.poll();
            
            if (++p[1] < n) {
                pq.offer(p);
            }
        }
        
        return new int[] {A[pq.peek()[0]], A[n - 1 - pq.peek()[1]]};
    }




    // SOLUTION TWO -- Using BinarySearch
    // Time: O(n * lg(MAX^2)), where MAX is the maximum element in A
    // Space: O(1)
    /*
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        double l = 0, r = 1;
        int p = 0, q = 1;
        
        for (int n = A.length, cnt = 0; true; cnt = 0, p = 0) {
            double m = (l + r) / 2;
            
            for (int i = 0, j = n - 1; i < n; i++) {
                while (j >= 0 && A[i] > m * A[n - 1 - j]) j--;
                cnt += (j + 1);
                
                if (j >= 0 && p * A[n - 1 - j] < q * A[i]) {
                    p = A[i];
                    q = A[n - 1 - j];
                }
            }
            
            if (cnt < K) {
                l = m;
            } else if (cnt > K) {
                r = m;
            } else {
                return new int[] {p, q};
            }
        }
    }
    */




    // SOLUTION THREE -- Using ZigzagSearch
    // Time: O(n^2), Space: O(1)
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        
        int row = 0; 
        int col = n - 1;
        
        for (int cnt_le = 0, cnt_lt = 0; true; cnt_le = 0, cnt_lt = 0) {
            for (int i = 0, j = n - 1, p = n - 1; i < n; i++) {
                while (j >= 0 && A[i] * A[n - 1 - col] > A[n - 1 - j] * A[row]) j--;
                cnt_le += (j + 1);
                    
                while (p >= 0 && A[i] * A[n - 1 - col] >= A[n - 1 - p] * A[row]) p--;
                cnt_lt += (p + 1);
            }
                
            if (cnt_le < K) {
                row++;
            } else if (cnt_lt >= K) {
                col--;
            } else {
                return new int[] {A[row], A[n - 1 - col]};
            }
        }
    }




    // My solution using the idea of Kth_378
    /*
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
        for (int j = 0; j < A.length; j++) 
            maxHeap.add(new Pair(0, j, A[0], A[j]));
        for (int i = 1; i < K; i++) {
            Pair pair = maxHeap.poll();
            if (pair.i == A.length - 1) continue;
            pair.i += 1;
            pair.p = A[pair.i];
            maxHeap.add(pair);
        }
        Pair res = maxHeap.peek();
        return new int[]{res.p, res.q};
    }
    
    class Pair implements Comparable<Pair> {
        int i, j;
        int p, q;
        
        Pair(int _i, int _j, int a, int b) {
            i = _i;
            j = _j;
            p = a;
            q = b;
        }
        
        @Override
        public int compareTo(Pair that) {
            return this.p * that.q - this.q * that.p;
        }
    }
    */



    // My solution using Priority Queue (TLE)
    // 59 / 62 test cases passed
    /*
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                maxHeap.add(new Pair(A[i], A[j]));
                if (maxHeap.size() > K) maxHeap.poll();
            }
        }
        Pair pair = maxHeap.peek();
        return new int[]{pair.p, pair.q};
    }
    
    private class Pair implements Comparable<Pair> {
        int p, q;

        Pair(int a, int b) {
            if (a < b) { p = a; q = b; } 
            else { p = b; q = a; }
        }
        
        @Override
        public int compareTo(Pair that) {
            return this.p * that.q - this.q * that.p;
        }
    }
    */
}
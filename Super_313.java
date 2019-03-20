import java.util.PriorityQueue;

class Super_313 {
    // Similar with Ugly_264
    // Note how we deal with duplicates

    // Most voted solution #3: Priority queue
    // Time: O(N lgk) ?
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n + 1];
        ugly[1] = 1;
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>();
        for (int prime : primes)
            minHeap.add(new Tuple(prime, 1, prime));
        for (int i = 2; i <= n; i++) {
            ugly[i] = minHeap.peek().val;
            while (minHeap.peek().val == ugly[i]) {
                Tuple t = minHeap.poll();
                t.idx++;
                t.val = t.p * ugly[t.idx];
                minHeap.add(t);
            }
        }
        return ugly[n];
    }
    
    
    private class Tuple implements Comparable<Tuple> {
        int val, idx, p;
        
        Tuple(int _val, int _idx, int _p) {
            val = _val;
            idx = _idx;
            p = _p;
        }
        
        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }


    // Most voted solution #1: Ugly_264
    // Time: O(kN)
    /*
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);

            //slip duplicate
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * ugly[idx[j]] == ugly[i]) idx[j]++;
            }
        }

        return ugly[n - 1];
    }
    */



    // Most voted solution #2
    // Time: O(kN)
    /*
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                //find next ugly number
                next = Math.min(next, val[j]);
            }
        }

        return ugly[n - 1];
    }
    */



    // Rewrite the two solutions above
    /*
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (ugly[idx[j]] * primes[j] == ugly[i]) 
                    idx[j]++;
                next = Math.min(next, ugly[idx[j]] * primes[j]);
            }
        }

        return ugly[n - 1];
    }
    */
}
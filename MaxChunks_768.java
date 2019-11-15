class Solution {
    // Most voted solution
    // Time: O(N), Space: O(N)
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }

        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) res++;
        }

        return res + 1;
    }



    // Second voted solution
    // Time: O(NlgN), Space: O(N)
    /*
    public int maxChunksToSorted(int[] arr) {
        int[] expect = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expect);
        int res = 0, sum1 = 0, sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 += expect[i];
            if (sum1 == sum2) res++;
        }
        return res;
    }
    */



    // Standard solution #1: Sliding Window
    /*
    public int maxChunksToSorted(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int res = 0, nonzero = 0;
        int[] expect = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expect);
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i], y = expect[i];
            
            int a = count.getOrDefault(x, 0) + 1;
            if (a == 0)
                nonzero--;
            else if (a == 1)
                nonzero++;
            count.put(x, a);
            
            int b = count.getOrDefault(y, 0) - 1;
            if (b == 0)
                nonzero--;
            else if (b == -1)
                nonzero++;
            count.put(y, b);
            
            if (nonzero == 0) res++;
        }
        return res;
    }
    */



    // Standard solution #2: Sorted Pairs
    // Similar idea to MaxChunks_769
    /*
    public int maxChunksToSorted(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Pair> original = new ArrayList<>();
        for (int a : arr) {
            freq.put(a, 1 + freq.getOrDefault(a, 0));
            original.add(new Pair(a, freq.get(a)));
        }
        List<Pair> expect = new ArrayList<>(original);
        Collections.sort(expect);
        Pair max = original.get(0);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            Pair X = original.get(i);
            if (max.compareTo(X) < 0) max = X;
            Pair Y = expect.get(i);
            if (max.compareTo(Y) == 0) res++;
        }
        return res;
    }
    
    class Pair implements Comparable<Pair> {
        int val, count;
        Pair(int v, int c) {
            val = v;
            count = c;
        }
        @Override
        public int compareTo(Pair that) {
            return this.val != that.val ? this.val - that.val : this.count - that.count;
        }
    }
    */
}
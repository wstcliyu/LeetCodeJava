class Maximum_164 {
    // Most voted solution: Bucket sort
    // Another solution is Radix sort
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int globalMin = nums[0];
        int globalMax = nums[0];
        for (int v : nums) {
            globalMin = Math.min(globalMin, v);
            globalMax = Math.max(globalMax, v);
        }
        int gap = (globalMax - globalMin - 1) / (n - 1) + 1;
        Bucket[] buckets = new Bucket[n - 1];
        int bucketIdx;
        for (int v : nums) {
            if (v == globalMax) continue;
            bucketIdx = (v - globalMin) / gap;
            if (buckets[bucketIdx] == null)
                buckets[bucketIdx] = new Bucket(v);
            else
                buckets[bucketIdx].update(v);
        }
        int prev = globalMin;
        int res = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            res = Math.max(res, buckets[i].localMin - prev);
            prev = buckets[i].localMax;
        }
        res = Math.max(res, globalMax - prev);
        return res;
    }
    
    class Bucket {
        int localMin, localMax;
        Bucket(int v) {
            localMin = localMax = v;
        }
        void update(int v) {
            localMin = Math.min(localMin, v);
            localMax = Math.max(localMax, v);
        }
    }
}
class Statistics_1093 {
    // My first solution: Binary Search
    public double[] sampleStats(int[] count) {
        int min = -1, max = 0;
        int mode = 0, maxFreq = 0;
        long sum = 0;
        int total = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxFreq) {
                maxFreq = count[i];
                mode = i;
            }
            total += count[i];
            sum += count[i] * i;
            
            if (count[i] > 0) {
                if (min < 0) min = i;
                max = i;
            }
            
            if (i > 0) count[i] += count[i - 1];
        }
        double mean = (double)sum / total;
        
        int target = (total + 1) / 2;
        int median1 = binarySearch(count, (total + 1) / 2);
        int median2 = binarySearch(count, (total + 2) / 2);
        double median = (median1 + median2) / 2.0;
        return new double[]{min, max, mean, median, mode};
    }
    
    private int binarySearch(int[] count, int target) {
        int l = 0, r = count.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (count[m] < target) l = m + 1;
            else r = m;
        }
        return r;
    }
}
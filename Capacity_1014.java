class Capacity_1014 {
    // My first solution (similar with most voted)
    public int shipWithinDays(int[] weights, int D) {
        int max = 0;
        for (int w : weights) max = Math.max(max, w);
        int l = max, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (daysNeed(weights, mid) > D)
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }
    
    private int daysNeed(int[] weights, int capacity) {
        int days = 0;
        int remain = capacity;
        for (int w : weights) {
            if (w > remain) {
                days++;
                remain = capacity - w;
            } else {
                remain -= w;
            }
        }
        return days + 1;
    }
}
class Koko_875 {
    // My first solution using binary search
    // Time: O(N lgM), where N = piles.length, M = max(pile)
    public int minEatingSpeed(int[] piles, int H) {
        int max = 0;
        for (int p : piles) max = Math.max(p, max);
        int l = 1, r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (timeNeed(piles, mid) > H)
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }
    
    private int timeNeed(int[] piles, int K) {
        int sum = 0;
        for (int p : piles) 
            sum += (p - 1) / K + 1;
        return sum;
    }
}
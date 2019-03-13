class Online_911 {
    // My first solution using binary search
    private int[] times, lead;

    public Online_911(int[] persons, int[] times) {
        int N = times.length;
        int[] votes = new int[N + 1];
        lead = new int[N];
        this.times = times;
        int max = -1;
        for (int i = 0; i < N; i++) {
            int candidate = persons[i];
            if (++votes[candidate] >= max) {
                max = votes[candidate];
                lead[i] = candidate;
            } else
                lead[i] = lead[i-1]; // Do not forget this line
        }
    }
    
    public int q(int t) {
        int p = Arrays.binarySearch(times, t);
        if (p >= 0) return lead[p];
        p = - p - 1;
        return lead[p - 1];
    }
}

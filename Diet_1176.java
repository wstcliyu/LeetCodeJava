class Diet_1176 {
    // My first solution
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int n = calories.length;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < k; i++) 
            sum += calories[i];
        for (int i = k - 1; i < n; i++) {
            if (sum < lower) res--;
            else if (sum > upper) res++;
            
            if (i < n - 1) sum = sum + calories[i + 1] - calories[i - k + 1];
        }
        return res;
    }
}
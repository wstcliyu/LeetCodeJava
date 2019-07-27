class Trapping_42 {
    // Standard solution #2: DP
    /*
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int res = 0;
        int N = height.length;
        int[] left_max = new int[N];
        int[] right_max = new int[N];
        left_max[0] = height[0];
        right_max[N - 1] = height[N - 1];
        for (int i = 1; i < N - 1; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        for (int i = N - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }
        for (int i = 1; i < N - 1; i++) {
            res += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return res;
    }
    */
    


    // My solution using two pointers
    // cannot understand standard solution #4
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1;
        int left_max = 0, right_max = 0;
        int res = 0;
        while (l <= r) {
            left_max = Math.max(left_max, height[l]);
            right_max = Math.max(right_max, height[r]);
            if (left_max < right_max) {
                res += left_max - height[l++];
            } else {
                res += right_max - height[r--];
            }
        }
        return res;
    }
}
class First_41 {
    // Rewrite standard solution
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        boolean hasOne = false;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 1) hasOne = true;
            // Only keep values [1, N]
            if (nums[i] <= 0 || nums[i] > N)
                nums[i] = 1;
        }
        if (!hasOne) return 1;
        
        for (int num : nums) {
            int v = Math.abs(num);
            nums[v - 1] = - Math.abs(nums[v - 1]);
        }
            
        
        for (int i = 0; i < N; i++)
            if (nums[i] > 0)
                return i + 1;
        return N + 1;
    }



    // Possible follow-up: find first missing non-negative integer
    /*
    public int firstMissingNonNegative(int[] nums) {
        int N = nums.length;
        boolean hasZero = false;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 0) hasZero = true;
            // Only keep values [0, N-1]
            if (nums[i] < 0 || nums[i] >= N)
                nums[i] = 0;
        }
        if (!hasZero) return 0;
        
        for (int v : nums) {
            if (v < 0)
                v = - v - 1;
            if (nums[v] >= 0)
                nums[v] = - nums[v] - 1;
        }
            
        
        for (int i = 0; i < N; i++)
            if (nums[i] >= 0)
                return i;
        return N;
    }
    */
}
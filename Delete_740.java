class Delete_740 {
    // This problem is similar with House Robber serial
    // Standard solution
    public int deleteAndEarn(int[] nums) {
        int[] values = new int[10001];
        for (int num : nums) values[num] += num;
        int skip = 0, take = 0, prev = -12345;
        for (int k = 1; k <= 10000; k++) {
            if (values[k] > 0) {
                int m = Math.max(skip, take);
                if (k - 1 == prev)
                    take = values[k] + skip;
                else
                    take = values[k] + m;
                skip = m;
                prev = k;
            }
        }
        return Math.max(skip, take);
    }




    // Most voted solution
    // https://leetcode.com/problems/delete-and-earn/discuss/109871/Awesome-Python-4-liner-with-explanation-Reduce-to-House-Robbers-Question-U0001f31d
    // I rewrite it in java
    /*
    public int deleteAndEarn(int[] nums) {
        int[] values = new int[10001];
        for (int num : nums) values[num] += num;
        int skip = 0, curr = 0;
        for (int k = 1; k <= 10000; k++) {
            int tmp = curr;
            curr = Math.max(values[k] + skip, curr);
            skip = tmp;
        }
        return curr;
    }
    */
}
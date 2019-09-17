import java.util.Stack;

class Minimum_1130 {
    // Most voted solution from lee215: Mono Stack
    // Similar to the idea of 1019 Next Greater Node in Linked List
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(Integer.MAX_VALUE);
        for (int a : arr) {
            while (a >= stack.peek()) {
                res += stack.pop() * Math.min(a, stack.peek());
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }



    // Brute Force: DP (TLE, 58/103 test cases passed)
    /*
    public int mctFromLeafValues(int[] arr) {
        int N = arr.length;
        return dfs(arr, new int[N][N], new int[N][N], 0, N - 1)[0];
    }
    
    private int[] dfs(int[] arr, int[][] max, int[][] dp, int start, int end) {
        if (dp[start][end] > 0 && max[start][end] > 0)
            return new int[]{dp[start][end], max[start][end]};
        
        if (start == end)
            return new int[]{0, arr[start]};
        
        int[] res = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int i = start; i < end; i++) {
            int[] left = dfs(arr, max, dp, start, i);
            int[] right = dfs(arr, max, dp, i + 1, end);
            res[0] = Math.min(res[0], left[0] + right[0] + left[1] * right[1]);
            res[1] = Math.max(left[1], right[1]);
        }
        
        return res;
    }
    */
}
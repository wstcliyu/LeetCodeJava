public class MaxChunks_769 {
    public static int maxChunksToSorted(int[] arr) {
        /* Most voted solution
         * Check the maximum of first k elements is k
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
        */
        int res = 0, i = 0, max;
        while (i < arr.length) {
            max = arr[i];
            while (i <= max) {
                max = Math.max(max, arr[i++]);
            }
            res++;
        }
        return res;
    }
    public static void main (String args[]) {
        int[] testArr = {1,0,2,3,4};
        System.out.println(maxChunksToSorted(testArr));
    }
}

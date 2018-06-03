public class ArrayNesting_565 {
    public static int arrayNesting(int[] nums) {
        /* Most voted solution
        int maxsize = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            for (int k = i; nums[k] >= 0; size++) {
                int ak = nums[k];
                nums[k] = -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }
        return maxsize;
        */
        int res = 0;
        int count = 0;
        boolean[] seen = new boolean[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (seen[i])
                continue;
            int j = i;
            int max = 0;
            do {
                max++;
                seen[j] = true;
                j = nums[j];
            } while (j != i);
            res = Math.max(res, max);
            count += max;
            if (nums.length - count <= res)
                return res;
        }
        return res;
    }
    public static void main (String args[]) {
        int[] testNums = {5,4,0,3,1,6,2};
        System.out.println(arrayNesting(testNums));
    }
}

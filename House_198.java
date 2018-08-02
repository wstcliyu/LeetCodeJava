public class House_198 {
    public int rob(int[] nums) {
        // My first solution, it is easy to improve to O(1) Space
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] steal = new int[len];
        int[] avoid = new int[len];
        steal[0] = nums[0];
        for (int i=1; i<len; i++) {
            steal[i] = avoid[i-1] + nums[i];
            avoid[i] = Math.max(avoid[i-1], steal[i-1]);
        }
        return Math.max(avoid[len-1], steal[len-1]);

        // Most voted solution
        /*
        int a = 0;
        int b = 0;
        for (int i=0; i<len; i++) {
            if (i%2==0)
                a = Math.max(a + nums[i], b); // a presents the optimal so far for i%2==0
            else
                b = Math.max(a, b + nums[i]); // b presents the optimal so far for i%2==1
        }
        return Math.max(a, b); // Math.max(a, b) == (i%2==0) ? a : b
        */
    }
}

public class Single_136 {
    public static int singleNumber(int[] nums) {
        // The most intuitive solution for me is using HashMap, but HashMap needs O(n) extra space.
        // Actually we can also use HashSet and a little math, 2(a+b+c)-(a+a+b+b+c)=c, also O(n) extra space.
        // The following method does not need extra space. we need to know a^b^c = (a^b)^c = a^(b^c).
        int result = 0;
        for (int i=0; i<nums.length; i++)
            result ^= nums[i];
        return result;
    }
}

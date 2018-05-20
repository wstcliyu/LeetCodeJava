public class OptimalDivision_553 {
    public static String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder(Integer.toString(nums[0]));
        for (int i=1; i<n; i++)
            result.append("/"+Integer.toString(nums[i]));
        if (n>2) {
            result.insert(result.indexOf("/")+1,"(");
            result.append(")");
        }
        return result.toString();
    }
    public static void main (String args[]) {
        int[] testNums = {1000,100};
        System.out.println(optimalDivision(testNums));
    }
}

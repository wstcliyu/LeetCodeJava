public class Third_414 {
    public static int thirdMax(int[] nums) {

        /** Most voted solution
         Integer max1 = null;
         Integer max2 = null;
         Integer max3 = null;
         for (Integer n : nums) {
         if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
         if (max1 == null || n > max1) {
         max3 = max2;
         max2 = max1;
         max1 = n;
         } else if (max2 == null || n > max2) {
         max3 = max2;
         max2 = n;
         } else if (max3 == null || n > max3) {
         max3 = n;
         }
         }
         return max3 == null ? max1 : max3;
         */

        int first = nums[0];
        int second = first, third = first;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > first) {
                third = second;
                second = first;
                first =nums[i];
            }
            if (nums[i] < first && ((nums[i] > second) || (second >= first)) ) {
                third = second;
                second = nums[i];
            }
            if (nums[i] < second && ((nums[i] > third) || (third >= second)) )
                third = nums[i];
        }
        if (third >= second)
            return first;
        return  third;
    }
    public static void main (String args[]) {
        int[] testNums = {2,2,2,1};
        System.out.println(thirdMax(testNums));
    }
}

public class Sum_633 {
    public static boolean judgeSquareSum(int c) {
        /** Use Math.sqrt
        for (int i=0; i<=Math.sqrt(c/2); i++) {
            int b = (int)Math.sqrt(c-i*i);
            if (i*i+b*b==c)
                return true;
        }
        return false;
         */

        // Two Pointers
        int left = 0;
        int right = (int)Math.sqrt(c);
        while(left <= right) {
            int sum = left*left + right*right;
            if (sum == c)
                return true;
            if (sum > c)
                right--;
            if (sum < c)
                left++;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
    }
}

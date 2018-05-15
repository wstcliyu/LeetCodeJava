public class Valid_367 {
    public static boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        int mid;
        while (left <= right) {
            mid = (left + right)/2;
            if (num%mid == 0 && mid == num/mid)
                return true;
            if (mid <= num/mid)
                left = mid + 1;
            if (mid > num/mid)
                right = mid - 1;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(25));
    }
}

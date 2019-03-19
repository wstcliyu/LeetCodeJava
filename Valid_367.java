public class Valid_367 {
    // My updated solution
    /*
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid < num/mid)
                left = mid + 1;
            else
                right = mid;
        }
        return num % left == 0 && left == num / left;
    }
    */



    public static boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left < right) {
            int mid = (left + right) / 2;
            if (num % mid == 0 && mid == num / mid)
                return true;
            if (mid <= num/mid)
                left = mid + 1;
            else
                right = mid;
        }
        return num % left == 0 && left == num / left;
    }
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(25));
    }
}

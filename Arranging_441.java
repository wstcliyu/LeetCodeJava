public class Arranging_441 {
    public static int arrangeCoins(int n) {
        /* 1+2+...+x<=n
            x^2+x-2n<=0
            Solve x
           */
        //return (int)(Math.sqrt(1+8.0*n))-1;

        //Binary Search
        long left = 0;
        long right = n;
        long mid;
        while (left <= right) {
            mid = (left + right)/2;
            if (mid*(mid+1)/2 <= n && (mid+1)*(mid+2)/2 > n)
                return (int)mid;
            if (mid*(mid+1)/2 > n)
                right = mid - 1;
            if ((mid+1)*(mid+2)/2 <= n)
                left = mid + 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(arrangeCoins(1804289383));
    }
}

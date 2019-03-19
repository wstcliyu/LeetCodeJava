public class Sqrt_69 {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1, r = x;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mid > x / mid)
                r = mid;
            else
                l = mid + 1;
        }
        return r - 1;
    }
    public static void main (String args[]) {
        System.out.println(mySqrt(10));
    }
}

public class Divide_29 {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int res = 0;
        while (dvs <= dvd) {
            long tmp = dvs;
            int multiple = 1;
            while (tmp <= dvd-tmp) {
                tmp <<= 1;
                multiple <<= 1;
            }
            dvd -= tmp;
            res += multiple;
        }
        return sign==1 ? res : -res;
    }
    public static void main(String[] args) {
        System.out.println(divide(-2147483648,1));
    }
}

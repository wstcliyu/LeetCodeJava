public class Factorial_172 {
    public static int trailingZeroes(int n) {
        int result = 0;
        int divider = 5;
        while (n/divider > 0) {
            result += n/divider;
            n = n/5;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(trailingZeroes(125));
    }
}

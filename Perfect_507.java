public class Perfect_507 {
    public static boolean checkPerfectNumber(int num) {
        if (num <= 1)
            return false;
        int result = num;
        for (int i=1; i*i<=num; i++) {
            if (num%i == 0) {
                if (i == 1 || i * i == num)
                    result = result - i;
                else
                    result = result - i - num / i;
            }
        }
        if (result == 0)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(2));
    }
}

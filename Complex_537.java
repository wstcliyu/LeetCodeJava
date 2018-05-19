public class Complex_537 {
    public static String complexNumberMultiply(String a, String b) {
        /* Standard solution, clear writing, should remember
         * String.split() Integer.parseInt(string)
        String x[] = a.split("\\+|i");
        String y[] = b.split("\\+|i");
        int a_real = Integer.parseInt(x[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_img = Integer.parseInt(y[1]);
        return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";
        */

        int[] aa = getRealAndComplex(a);
        int[] bb = getRealAndComplex(b);
        int real = aa[0]*bb[0]-aa[1]*bb[1];
        int complex = aa[0]*bb[1]+aa[1]*bb[0];
        return Integer.toString(real)+"+"+Integer.toString(complex)+"i";
    }
    public static int[] getRealAndComplex(String a) {
        int[] result = new int[2];
        int n = a.length();
        int sign = 1;
        int j = 0;
        for (int i=0; i<n; i++) {
            if (a.charAt(i) == '-')
                sign = -1;
            if (a.charAt(i)-'0' <= 9 && a.charAt(i)-'0' >= 0) {
                result[j] = result[j]*10+a.charAt(i)-'0';
            }
            if (a.charAt(i) == '+') {
                result[0] *= sign;
                j = 1;
                sign = 1;
            }
            if (a.charAt(i) == 'i')
                result[1] *= sign;
        }
        return result;
    }
    public static void main (String args[]) {
        String testA = "-1+1i";
        String testB = "1+1i";
        System.out.println(complexNumberMultiply(testA,testB));
    }
}

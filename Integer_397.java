public class Integer_397 {
    public static int integerReplacement(int n) {
        int res = 0;
        while (n != 1) {
            if ((n&1) == 0)
                // Use >>> instead of >>, otherwise it will exceed time limit when n=2147483647
                n >>>= 1;
            // Alternative writting
            // else if(n == 3 || Integer.bitCount(n - 1) < Integer.bitCount(n + 1))
            else if (n==3 || ((n>>>1)&1) == 0)
                n -= 1;
            else
                n += 1;
            res++;
        }
        return res;
    }
    public static void main (String args[]) {
        System.out.println(integerReplacement(2147483647));
        System.out.println(2147483647+1);
    }
}

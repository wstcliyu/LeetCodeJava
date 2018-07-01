public class Pow_50 {
    public double myPow(double x, int n) {
        // return Math.pow(x,1.0*n);
        if (n == 0)
            return 1.0;
        if (n == Integer.MIN_VALUE)
            return myPow(x*x, n/2);
        if (n < 0)
            return myPow(1/x, -n);
        return n%2==0 ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}

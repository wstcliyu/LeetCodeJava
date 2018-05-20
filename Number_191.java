public class Number_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // return Integer.bitCount(n);
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}

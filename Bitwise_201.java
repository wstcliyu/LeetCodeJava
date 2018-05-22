public class Bitwise_201 {
    public static int rangeBitwiseAnd(int m, int n) {
        /* 1. last bit of (odd number & even number) is 0.
           2. when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
           3. Move m and n rigth a position.
        if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
        */

        int res = 0;
        for (int i=31; i>=0; i--) {
            if (getBit(m,i) && getBit(n,i))
                res |= (1<<i);
            if (!getBit(m,i) && getBit(n,i))
                break;
        }
        return res;
    }
    public static boolean getBit(int n, int i) {
        return (n&(1<<i)) != 0;
    }
    public static void main (String args[]) {
        System.out.println(rangeBitwiseAnd(0,1));
    }
}

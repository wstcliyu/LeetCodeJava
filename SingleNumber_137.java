import java.util.Arrays;

public class SingleNumber_137 {
    private static int singleNumber(int[] nums) {
        // I wrote this after reading the most voted solution
        int a = 0, b = 0;
        for (int n:nums) {
            for (int i=0; i<32; i++) {
                if (getBit(n,i)) {
                    if (!getBit(a,i) && !getBit(b,i))
                        a |= (1<<i);
                    else if (getBit(a,i) && !getBit(b,i)) {
                        b |= (1<<i);
                        a &= ~(1<<i);
                    }
                    else if (!getBit(a,i) && getBit(b,i))
                        b &= ~(1<<i);
                }
            }
        }
        return a;
    }
    private static boolean getBit(int n,int i) {
        return (n&(1<<i)) != 0;
    }
    public static void main (String args[]) {
        int[] testNums = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(testNums));
    }
}

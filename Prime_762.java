import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prime_762 {
    public static int countPrimeSetBits(int L, int R) {
        int count = 0;
//        Set<Integer> primes = new HashSet<>(Arrays.asList(new Integer[]{2,3,5,7,11,13,17,19}));
        Set<Integer> primes = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19));
        for (int num=L; num<=R; num++) {
            if (primes.contains(Integer.bitCount(num)))
                count++;
        }
        return count;
    }
    public static void main (String args[]) {
        int testL = 10, testR = 15;
        System.out.println(countPrimeSetBits(testL,testR));
    }
}

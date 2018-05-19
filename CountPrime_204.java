import java.util.ArrayList;
import java.util.List;

public class CountPrime_204 {
    public static int countPrimes(int n) {
        /*
        if (n < 3)
            return 0;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i=3; i<n; i++) {
            int j;
            for (j=0; j<primes.size(); j++) {
                if (i%primes.get(j) == 0)
                    break;
                if (primes.get(j)*primes.get(j) >= i)
                    j = primes.size()-1;
            }
            if (j == primes.size())
                primes.add(i);
        }
        return primes.size();
        */
        boolean[] Heshu = new boolean[n];
        int count = 0;
        for (int i=2; i<n; i++) {
            if (!Heshu[i]) {
                count++;
                for (int j=2; j*i<n; j++)
                    Heshu[j*i] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int testNum = 1500000;
        System.out.println(countPrimes(testNum));
    }
}

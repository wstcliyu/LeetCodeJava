import java.util.HashSet;
import java.util.Set;

public class BulbSwitcher_672 {
    public static int flipLights(int n, int m) {
        // Integer.valueOf("111111",2) convert 111111 to binary
        Set<Integer> seen = new HashSet<>();
        n = Math.min(n,6);
        int op[] = new int[4];
        op[0] = Integer.valueOf("111111",2) >> (6-n);
        op[1] = Integer.valueOf("101010",2) >> (6-n);
        op[2] = Integer.valueOf("010101",2) >> (6-n);
        op[3] = Integer.valueOf("100100",2) >> (6-n);
        for (int cand=0; cand<16; cand++) {
            if (Integer.bitCount(cand)<=m && Integer.bitCount(cand)%2==m%2) {
                int status = (1<<n) - 1;
                for (int i=0; i<4; i++) {
                    if (((cand>>i) & 1) != 0)
                        status ^= op[i];
                }
                seen.add(status);
            }
        }
        return seen.size();
        /* Refer to the Approach #2 of the standard solution
        n = Math.min(n, 3);
        if (m == 0) return 1;
        if (m == 1) return n == 1 ? 2 : n == 2 ? 3 : 4;
        if (m == 2) return n == 1 ? 2 : n == 2 ? 4 : 7;
        return n == 1 ? 2 : n == 2 ? 4 : 8;
        */
    }
    public static void main (String args[]) {
        int testN = 3;
        int testM = 3;
        System.out.println(flipLights(testN, testM));
    }
}

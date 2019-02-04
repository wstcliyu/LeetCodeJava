import java.util.Arrays;

public class ThreeSum_923 {
    // Similar with three sum
    final static int d = (int)Math.pow(10, 9) + 7;

    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int newTar = target - A[i];
            int j = i + 1, k = A.length - 1;
            while (j < k) {
                if (A[j] + A[k] < newTar) j++;
                else if (A[j] + A[k] > newTar) k--;
                else if (A[j] == A[k]) {
                    int tmp = (k - j + 1) * (k - j) / 2;
                    res = (res + tmp) % d;
                    break;
                } else {
                    int anchor_j = j, anchor_k = k;
                    while (A[j] == A[anchor_j]) j++;
                    while (A[k] == A[anchor_k]) k--;
                    res = (res + (j - anchor_j) * (anchor_k - k)) % d;
                }
            }
        }
        return res;
    }


    // Standard solution 2: Counting with cases
    // Time: O(N + W^2), where N is the length of A, and W is the number of possible values in A[i]
    /*
    public int threeSumMulti(int[] A, int target) {
        int[] count = new int[101];
        for (int a : A) count[a]++;
        int res = 0;

        for (int x = 0; x <= 100 && 3 * x < target; x++) {
            for (int y = x + 1; y <= 100 && x + 2 * y < target; y++) {
                int z = target - x - y;
                if (z <= 100) res = (res + count[x] * count[y] * count[z]) % d;
            }
        }

        for (int x = 0; x <= 100 && 3 * x < target; x++) {
            int z = target - 2 * x;
            if (z <= 100) res = (res + count[z] * count[x] * (count[x] - 1) / 2) % d;
        }

        for (int x = 0; x <= 100 && 3 * x < target; x++) {
            if (target % 2 == x % 2) {
                int y = (target - x) / 2;
                if (y <= 100) res = (res + count[x] * count[y] * (count[y] - 1) / 2) % d;
            }
        }

        if (target % 3 == 0 && target <= 300) {
            int x = target / 3;
            long tmp = count[x];
            tmp = (tmp * (tmp - 1) * (tmp - 2) / 6) % d;
            res = (res + (int)tmp) % d;
        }

        return res;
    }
    */


    // Standard solution #3: Combine the two solutions above
    /*
    public int threeSumMulti(int[] A, int target) {
        long[] count = new long[101];
        int uniq = 0;
        for (int x : A) if (count[x]++ == 0) uniq++;
        int[] keys = new int[uniq];
        int t = 0;
        for (int i = 0; i <= 100; ++i) if (count[i] > 0) keys[t++] = i;

        long ans = 0;

        for (int i = 0; i < keys.length; ++i) {
            int x = keys[i];
            int T = target - x;
            int j = i, k = keys.length - 1;
            while (j <= k) {
                int y = keys[j], z = keys[k];
                if (y + z < T) j++;
                else if (y + z > T) k--;
                else {
                    if (i < j && j < k) ans += count[x] * count[y] * count[z];
                    else if (i == j && j < k) ans += count[x] * (count[x] - 1) / 2 * count[z];
                    else if (i < j && j == k) ans += count[x] * count[y] * (count[y] - 1) / 2;
                    else ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;

                    ans %= d;
                    j++;
                    k--;
                }
            }
        }

        return (int) ans;
    }
    */
}

public class Largest_949 {
    public String largestTimeFromDigits(int[] A) {
        int ans = -1;

        // Choose different indices i, j, k, l as a permutation of 0, 1, 2, 3
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j) if (j != i)
                for (int k = 0; k < 4; ++k) if (k != i && k != j) {
                    int l = 6 - i - j - k;

                    // For each permutation of A[i], read out the time and record the largest legal time.
                    int hours = 10 * A[i] + A[j];
                    int mins = 10 * A[k] + A[l];
                    if (hours < 24 && mins < 60)
                        ans = Math.max(ans, hours * 60 + mins);
                }

        // https://stackoverflow.com/questions/3377688/what-do-these-symbolic-strings-mean-02d-01d
        // %[argument_index$][flags][width][.precision]conversion
        // %02d performs decimal integer conversion d, formatted with zero padding (0 flag), with width 2
        return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
    }

    public static void main(String[] args) {
        System.out.printf("%2$-6s : %6s%n", "test1", "test2");
        //test2  :  test1
    }
}
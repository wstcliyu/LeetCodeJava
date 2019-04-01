class Numbers_1012 {
    // Most voted solution
    // https://leetcode.com/problems/numbers-with-repeated-digits/discuss/256725/JavaPython-Count-the-Number-Without-Repeated-Digit
    public int numDupDigitsAtMostN(int N) {
        List<Integer> digits = new ArrayList<>();
        for (int x = N + 1; x > 0; x /= 10)
            digits.add(0, x % 10);
        
        int res = 0, n = digits.size();
        for (int i = 1; i < n; i++)
            res += 9 * P(9, i - 1);
        
        boolean[] used = new boolean[10];
        for (int i = 0; i < n; i++) {
            int digit = digits.get(i);
            for (int j = i > 0 ? 0 : 1; j < digit; j++) {
                if (!used[j]) res += P(9 - i, n - i - 1);
            }
            if (used[digit]) break;
            used[digit] = true;
        }
        
        return N - res;
    }
    
    private int P(int m, int n) {
        return n == 0 ? 1 : (m - n + 1) * P(m, n - 1);
    }
}
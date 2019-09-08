class Count_1180 {
    // My first solution: DP
    public int countLetters(String S) {
        int res = 1;
        int sum = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                sum = 1;
            } else {
                sum++;
            }
            res += sum;
        }
        return res;
    }
}
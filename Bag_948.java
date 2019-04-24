class Bag_948 {
    // My first solution: Greedy
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int res = 0, point = 0;
        int i = 0, j = tokens.length - 1;
        while (i <= j) {
            if (P >= tokens[i]) {
                res = Math.max(res, ++point);
                P -= tokens[i];
                i++;
            } else if (point > 0) {
                point--;
                P += tokens[j];
                j--;
            } else
                break;
        }
        return res;
    }
}
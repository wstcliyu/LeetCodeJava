class Letter_1079 {
    // Most voted solution
    // Good question on how to count permutations using recursion
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char c : tiles.toCharArray()) freq[c - 'A']++;
        return dfs(freq);
    }
    
    private int dfs(int[] freq) {
        int sum = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) continue;
            sum++;
            freq[i]--;
            sum += dfs(freq);
            freq[i]++;
        }
        return sum;
    }
}
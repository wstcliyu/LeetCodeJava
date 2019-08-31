class Single_1165 {
    // My first solution
    public int calculateTime(String keyboard, String word) {
        int[] indices = new int[26];
        for (int i = 0; i < 26; i++) {
            indices[keyboard.charAt(i) - 'a'] = i;
        }
        int res = 0;
        int prev = 0;
        for (char c : word.toCharArray()) {
            res += Math.abs(prev - indices[c - 'a']);
            prev = indices[c - 'a'];
        }
        return res;
    }
}
class Height_1051 {
    // Most voted solution: counting sort
    public int heightChecker(int[] heights) {
        int[] freq = new int[101];
        for (int h : heights) freq[h]++;
        int h = 0;
        int res = 0;
        for (int height : heights) {
            while (freq[h] == 0) h++;
            if (height != h) res++;
            freq[h]--;
        }
        return res;
    }
}
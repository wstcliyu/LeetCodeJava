class Video_1024 {
    // My first solution using BFS (similar idea with my solution to Jump_45, Jump_55)
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, Comparator.<int[]>comparingInt(clip -> clip[0]));
        int preMax, curMax = 0, res = 0;
        do {
            res++;
            preMax = curMax;
            for (int i = 0; i < clips.length && clips[i][0] <= preMax; i++)
                curMax = Math.max(curMax, clips[i][1]);
        } while (curMax < T && preMax < curMax);
        
        return curMax >= T ? res : -1;    
    }
}
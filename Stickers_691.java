class Stickers_691 {
    // My first solution: BFS
    class Result {
        boolean improved, finished, visited;
        Result() {
            improved = false;
            finished = true;
            visited = false;
        }
    }
    
    public int minStickers(String[] stickers, String target) {
        List<Integer> need = makeList(target);
        List<List<Integer>> offers = new ArrayList<>();
        for (String sticker : stickers)
            offers.add(makeList(sticker));
        Set<List<Integer>> seen = new HashSet<>();
        seen.add(need);
        Deque<List<Integer>> q = new ArrayDeque<>();
        q.addLast(need);
        int res = 0;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                List<Integer> ls = q.removeFirst();
                for (List<Integer> offer : offers) {
                    List<Integer> clone = new ArrayList<>(ls);
                    Result r = listSubtract(clone, offer, seen);
                    if (r.finished) return res + 1;
                    if (r.improved && !r.visited) q.addLast(clone);
                }
            }
            res++;
        }
        return -1;
    }
    
    private List<Integer> makeList(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray())
            count[c - 'a']++;
        List<Integer> ls = new ArrayList<>();
        for (int num : count) ls.add(num);
        return ls;
    }
    
    private Result listSubtract(List<Integer> need, List<Integer> offer, Set<List<Integer>> seen) {
        Result r = new Result();
        for (int i = 0; i < need.size(); i++) {
            int n = need.get(i);
            int o = offer.get(i);
            if (n > o) r.finished = false;
            if (n > 0 && o > 0) r.improved = true;
            need.set(i, Math.max(0, n - o));
        }
        if (!seen.add(need)) r.visited = true;
        return r;
    }



    // Most voted solution: DFS with memoization
    /*
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int[][] mp = new int[m][26];
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < m; i++) 
            for (char c:stickers[i].toCharArray()) mp[i][c-'a']++;
        dp.put("", 0);
        return helper(dp, mp, target);
    }

    private int helper(Map<String, Integer> dp, int[][] mp, String target) {
        if (dp.containsKey(target)) return dp.get(target);
        int ans = Integer.MAX_VALUE, n = mp.length;
        int[] tar = new int[26];
        for (char c:target.toCharArray()) tar[c-'a']++;
        // try every sticker
        for (int i = 0; i < n; i++) {
            // optimization
            if (mp[i][target.charAt(0)-'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            // apply a sticker on every character a-z
            for (int j = 0; j < 26; j++) {
                if (tar[j] > 0 ) 
                    for (int k = 0; k < Math.max(0, tar[j]-mp[i][j]); k++)
                        sb.append((char)('a'+j));
            }
            String s = sb.toString();
            int tmp = helper(dp, mp, s);
            if (tmp != -1) ans = Math.min(ans, 1+tmp);
        }
        dp.put(target, ans == Integer.MAX_VALUE? -1:ans);
        return dp.get(target);
    }
    */



    // Standard solution #2: DP
    /*
    public int minStickers(String[] stickers, String target) {
        int N = target.length();
        int[] dp = new int[1 << N];
        for (int i = 1; i < 1 << N; i++) dp[i] = -1;

        for (int state = 0; state < 1 << N; state++) {
            if (dp[state] == -1) continue;
            for (String sticker: stickers) {
                int now = state;
                for (char letter: sticker.toCharArray()) {
                    for (int i = 0; i < N; i++) {
                        if (((now >> i) & 1) == 1) continue;
                        if (target.charAt(i) == letter) {
                            now |= 1 << i;
                            break;
                        }
                    }
                }
                if (dp[now] == -1 || dp[now] > dp[state] + 1) {
                    dp[now] = dp[state] + 1;
                }
            }
        }
        return dp[(1 << N) - 1];
    }
    */
}
class Strobogrammatic_248 {
    // Most voted solution: backtrack/dfs
    private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};
    private int res;
    
    public int strobogrammaticInRange(String low, String high) {
        res = 0;
        for (int len = low.length(); len <= high.length(); len++) {
            char[] chars = new char[len];
            dfs(low, high, chars, 0, len - 1);
        }
        return res;
    }
    
    private void dfs(String low, String high, char[] chars, int left, int right) {
        if (left > right) {
            String s = new String(chars);
            if ((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0))
                return;
            res++;
        } else {
            for (char[] pair : pairs) {
                chars[left] = pair[0];
                chars[right] = pair[1];
                if (chars.length > 1 && chars[0] == '0')
                    continue;
                if (left == right && pair[0] != pair[1])
                    continue;
                dfs(low, high, chars, left + 1, right - 1);
            }
        }
    }
}
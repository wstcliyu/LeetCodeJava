public class Number_806 {
    public int[] numberOfLines(int[] widths, String S) {
        int[] res = new int[2];
        res[0] = 1;
        for (char c : S.toCharArray()) {
            if (res[1] + widths[c-'a'] > 100) {
                res[0] ++;
                res[1] = 0;
            }
            res[1] += widths[c-'a'];
        }
        return res;
    }
}

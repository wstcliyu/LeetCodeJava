public class CountBinarySubstrings_696 {
    // Standard solution #2: Linear Scan
    public static int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }


    // My first solution (similar with standard solution #2)
    /*
    public static int countBinarySubstrings(String s) {
        int count = 0;
        int consecutive = 0;
        int n = s.length();
        int i = 0;
        while(i<n) {
            int j = i;
            while (j<n && s.charAt(j)==s.charAt(i))
                j++;
            count += Math.min(j-i, consecutive);
            if (j == n)
                break;
            consecutive = j-i;
            i = j;
        }
        return count;
    }
    */

    public static void main (String args[]) {
        String testS = "00110011";
        System.out.println(countBinarySubstrings(testS));
    }
}

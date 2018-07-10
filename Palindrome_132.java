import java.util.Arrays;

public class Palindrome_132 {
    // Most voted solution
    // Space O(n)
    public int minCut(String s) {
        if (s == null || s.length() <= 1)
            return 0;
        int len = s.length();
        int[] cut = new int[len+1]; // number of cuts for the first k characters
        for (int i=0; i<=len; i++)
            cut[i] = i-1;
        for (int i=0; i<len; i++) {
            for (int j=0; i-j>=0 && i+j<len && s.charAt(i-j) == s.charAt(i+j); j++)
                cut[i+j+1] = Math.min(cut[i+j+1], 1+cut[i-j]);
            for (int j=0; i-j-1>=0 && i+j<len && s.charAt(i-j-1) == s.charAt(i+j); j++)
                cut[i+j+1] = Math.min(cut[i+j+1], 1+cut[i-j-1]);
        }
        return cut[len];
    }
    // My first solution
    /*
    public int minCut(String s) {
        if (s == null || s.length() <= 1)
            return 0;
        int len = s.length();
        int[][] tmp = new int[len][len];
        return helper(s, 0, len-1, tmp) - 1;
    }
    private int helper(String s, int start, int end, int[][] tmp) {
        if (tmp[start][end] != 0)
            return tmp[start][end];
        if (isPalindrome(s, start, end)) {
            tmp[start][end] = 1;
            return 1;
        }
        int res = end-start+1;
        for (int i=start; i<=end-1; i++) {
            res = Math.min(res, helper(s,start,i,tmp)+helper(s,i+1,end,tmp));
            if (res == 2)
                break;
        }
        tmp[start][end] = res;
        return res;
    }
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
    */
    public static void main(String[] args) {
        Palindrome_132 test = new Palindrome_132();
        System.out.println(test.minCut("aab"));
    }
}

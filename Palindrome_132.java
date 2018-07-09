import java.util.Arrays;

public class Palindrome_132 {
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
    public static void main(String[] args) {
        Palindrome_132 test = new Palindrome_132();
        System.out.println(test.minCut("aab"));
    }
}

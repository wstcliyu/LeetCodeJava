public class Valid_680 {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0)
            return false;
        int l = 0, r = s.length()-1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return helper(s, l+1, r) || helper(s, l, r-1);
            l++;
            r--;
        }
        return true;
    }
    private boolean helper(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String testS = "abca";
        Valid_680 testClass = new Valid_680();
        System.out.println(testClass.validPalindrome(testS));
    }
}

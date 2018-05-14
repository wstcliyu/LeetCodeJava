public class Palindrome_9 {
    public boolean isPalindrome(int x) {
        if (x<0 || (x%10==0 && x!=0))
            return false;
        int revert = 0;
        while (x>revert) {
            revert = revert * 10 + x % 10;
            x = x/10;
        }
        if (x == revert || x == revert/10)
            return true;
        return false;
    }
}

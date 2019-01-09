public class Palindrome_9 {
    public boolean isPalindrome(int x) {
        // compare half of the digits in x, so don't need to deal with overflow
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int revert = 0;
        while (x > revert) {
            revert = revert * 10 + x % 10;
            x = x/10;
        }
        return x == revert || x == revert/10;
    }
}

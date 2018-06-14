public class Valid_125 {
    public static boolean isPalindrome(String s) {
        // Good practice for two pointers
        int left = 0, right = s.length()-1;
        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
            /* My solution
            while (left < right) {
                if (Character.isLetterOrDigit(cLeft))
                    break;
                else
                    left++;
            }
            while (left < right) {
                if (Character.isLetterOrDigit(cRight))
                    break;
                else
                    right--;
            }
            if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight))
                return false;
            left++;
            right--;
            */
            if (!Character.isLetterOrDigit(cLeft))
                left++;
            else if (!Character.isLetterOrDigit(cRight))
                right--;
            else if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
    public static void main (String[] args) {
        String testS = "race a car";
        System.out.println(isPalindrome(testS));
    }
}

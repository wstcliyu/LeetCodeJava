public class Valid_125 {
    // Palindrome using two pointers template
    // Updated my solutinon
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }



    /*
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
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
    */

    public static void main (String[] args) {
        String testS = "race a car";
        System.out.println(isPalindrome(testS));
    }
}

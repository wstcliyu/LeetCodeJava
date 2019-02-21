public class DetectCapital_520 {
    public static boolean detectCapitalUse(String word) {
        int n = word.length();
        int countCapital = 0;
        for (int i=0; i<n; i++) {
            char c = word.charAt(i);
            // Character.isUpperCase(c)
            if (c-'A'>=0 && c-'A'<26) countCapital++;
        }
        /*
        if (countCapital == n || countCapital == 0)
            return true;
        char c = word.charAt(0);
        if (countCapital == 1 && c-'A'>=0 && c-'A'<26)
            return true;
        return false;
        */
        return countCapital == n || countCapital == 0 || countCapital == 1 && Character.isUpperCase(word.charAt(0));
    }
    public static void main (String args[]) {
        String testWord = "FlaG";
        System.out.println(detectCapitalUse(testWord));
    }
}

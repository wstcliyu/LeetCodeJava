public class Length_58 {
    public static int lengthOfLastWord(String s) {
        // Most voted solution
        /*
        int len = 0, tail = s.length() - 1;
        while (tail >= 0 && s[tail] == ' ') tail--;
        while (tail >= 0 && s[tail] != ' ') {
            len++;
            tail--;
        }
        return len;
        */
        if (s == null || s.length() == 0)
            return 0;
        String[] words = s.split(" ");
        if (words.length == 0)
            return 0;
        return words[words.length-1].length();
    }
    public static void main(String[] args) {
        String testS = "HelloWorld ";
        System.out.println(lengthOfLastWord(testS));
    }
}

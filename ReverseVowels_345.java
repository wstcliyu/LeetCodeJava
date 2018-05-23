public class ReverseVowels_345 {
    public static String reverseVowels(String s) {
        int i = 0, j = s.length()-1;
        String vowels = "aeiouAEIOU";
        char ch[] = s.toCharArray();
        /* My first solution
        StringBuilder res = new StringBuilder(s);
        while (i < j) {
            if (vowels.indexOf(ch[i]) >= 0) {
                while (i < j) {
                    if (vowels.indexOf(ch[j]) >= 0) {
                        res.setCharAt(i, ch[j]);
                        res.setCharAt(j--, ch[i]);
                        break;
                    }
                    j--;
                }
            }
            i++;
        }
        return res.toString();
        */
        while (i < j) {
            while (i<j && vowels.indexOf(ch[i]) < 0)
                i++;
            while (i<j && vowels.indexOf(ch[j]) < 0)
                j--;
            if (i < j) {
                char tmp = ch[i];
                ch[i++] = ch[j];
                ch[j--] = tmp;
            }
        }
        // Constructor for String: new String(char[] value)
        return new String(ch);
    }
    public static void main (String args[]) {
        String testS = "leetcode";
        System.out.println(reverseVowels(testS));
    }
}

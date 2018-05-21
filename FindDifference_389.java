public class FindDifference_389 {
    public static char findTheDifference(String s, String t) {
        /* Most voted solution using Bit Manipulation
        int n = t.length();
        char c = t.charAt(n - 1);
        for (int i = 0; i < n - 1; ++i) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
        */
        int sumS = 0, sumT = 0;
        for (int i=0; i<s.length(); i++)
            sumS += s.charAt(i) - 'a';
        for (int i=0; i<t.length(); i++)
            sumT += t.charAt(i) - 'a';
        return (char)(sumT - sumS + 'a');
    }
    public static void main (String args[]) {
        String testS = "abcd";
        String testT = "abcde";
        System.out.println(findTheDifference(testS,testT));
    }
}

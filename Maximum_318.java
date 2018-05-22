public class Maximum_318 {
    public static int maxProduct(String[] words) {
        // There are 26 lower case letters in total.
        // So we can use a 32-bit integer to record which letters have appeared
        int res = 0;
        int n = words.length;
        int[] val = new int[n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<words[i].length(); j++)
                val[i] |= 1<<(words[i].charAt(j)-'a');
        }
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if ((val[i]&val[j]) == 0)
                    res = Math.max(res, words[i].length()*words[j].length());
            }
        }
        return res;
    }
    public static void main (String args[]) {
        String[] testWords = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(testWords));
    }
}

public class Verifying_953 {
    // Most voted solution, with the same thought but better written than mine
    int[] mapping = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++)
            mapping[order.charAt(i) - 'a'] = i;
        for (int i = 1; i < words.length; i++)
            if (compare(words[i - 1], words[i]) > 0)
                return false;
        return true;
    }

    int compare(String s1, String s2) {
        int n = s1.length(), m = s2.length(), cmp = 0;
        for (int i = 0, j = 0; i < n && j < m && cmp == 0; i++, j++) {
            cmp = mapping[s1.charAt(i) - 'a'] - mapping[s2.charAt(j) - 'a'];
        }
        return cmp == 0 ? n - m : cmp;
    }


    // My first solution
    /*
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        for (int i = 0; i < order.length(); i++)
            dict[order.charAt(i) - 'a'] = i;
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], dict) > 0)
                return false;
        }
        return true;
    }

    private int compare(String a, String b, int[] dict) {
        int m = a.length(), n = b.length();
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i == m) return -1;
            if (j == n) return 1;
            char c1 = a.charAt(i), c2 = b.charAt(j);
            if (dict[c1 - 'a'] < dict[c2 - 'a']) return -1;
            else if (dict[c1 - 'a'] > dict[c2 - 'a']) return 1;
            i++; j++;
        }
        return 0;
    }
    */
}

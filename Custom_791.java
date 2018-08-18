public class Custom_791 {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for (char c : S.toCharArray())
            freq[c - 'a']++;
        for (char c : T.toCharArray()) {
            if (freq[c - 'a'] > 0)
                freq[c - 'a']++;
            else
                sb.append(c);
        }
        for (char c : S.toCharArray()) {
            for (int i=1; i<freq[c - 'a']; i++)
                sb.append(c);
        }
        return sb.toString();
    }
}

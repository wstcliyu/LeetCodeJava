import java.util.HashMap;

public class LongestPalindrome_409 {
    public static int longestPalindrome(String s) {
        /* The ascii code of A and a is 65 and 97, respectively.
         * So the 52 letters can be covered by int[58] array.
        int[] letters = new int[58];
        for (char ch : s.toCharArray()) {
            letters[ch - 'A']++;
        }
        */
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch:s.toCharArray())
            map.put(ch, 1+map.getOrDefault(ch, 0));
        for (int val:map.values())
            res += val/2*2;
        return res<s.length() ? res+1 : res;
    }
}

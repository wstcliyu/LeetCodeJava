import java.util.HashMap;

public class Word_290 {
    public boolean wordPattern(String pattern, String str) {
        String[] word = str.split(" ");
        if (word.length != pattern.length())
            return false;
        /* Same thought as 205 Isomorphic
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<String, Integer> sMap = new HashMap<>();
        for (int i=0; i<word.length; i++) {
            // Use intValue() or equals() to compare Integer Objects
            if (pMap.getOrDefault(pattern.charAt(i),-1).intValue() != sMap.getOrDefault(word[i],-1))
                return false;
            else {
                pMap.put(pattern.charAt(i), i);
                sMap.put(word[i], i);
            }
        }
        */
        HashMap<Character,String> map = new HashMap<>();
        for (int i=0; i<word.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                // Use equals() to compare strings
                if (!map.get(pattern.charAt(i)).equals(word[i]))
                    return false;
            }
            // It is OK to use map.containsValue(String s)
            else if (map.containsValue(word[i]))
                return false;
            else
                map.put(pattern.charAt(i), word[i]);
        }
        return true;
    }
}

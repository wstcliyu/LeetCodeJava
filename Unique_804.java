import java.util.HashSet;

public class Unique_804 {
    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (String s:words) {
            StringBuilder sb = new StringBuilder();
            for (char c:s.toCharArray())
                sb.append(morse[c-'a']);
            set.add(sb.toString());
        }
        return set.size();
    }
}

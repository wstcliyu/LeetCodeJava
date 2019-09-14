import java.util.Set;
import java.util.HashSet;

class Sentence_734 {
    // Standard Approach: Set
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length)
            return false;
        final String SPLITER = ",";
        Set<String> set = new HashSet<>();
        for (List<String> p : pairs)
            set.add(p.get(0) + SPLITER + p.get(1));
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i]) &&
               !set.contains(words1[i] + SPLITER + words2[i]) &&
               !set.contains(words2[i] + SPLITER + words1[i]))
                return false;
        }
        return true;
    }
}
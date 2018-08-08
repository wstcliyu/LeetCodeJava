import java.util.*;

public class Most_819 {
    // https://leetcode.com/problems/most-common-word/discuss/123854/C++JavaPython-Easy-Solution-with-Explanation
    // The regex for punctuations is "\\pP"
    // The regex for one or more white space is "\\s+"
    // Comparator for entries of a map: Map.Entry.comparingByValue()
    public static String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.replaceAll("\\pP", "").toLowerCase().split("\\s+");
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words)
            if (!ban.contains(word))
                count.put(word, 1 + count.getOrDefault(word, 0));
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
    public static void main(String[] args) {
        String testParagraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] testBanned = {"hit"};
        String testResult = mostCommonWord(testParagraph, testBanned);
        System.out.println(testResult);
    }
}

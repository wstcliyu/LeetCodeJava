import java.util.*;

public class Most_819 {
    // https://leetcode.com/problems/most-common-word/discuss/123854/C++JavaPython-Easy-Solution-with-Explanation
    // The regex for punctuations is "\\pP"
    // The regex for one or more white space is "\\s+"
    // Comparator for entries of a map: Map.Entry.comparingByValue()
    public static String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban = new HashSet<>(Arrays.asList(banned));
        // String[] words = paragraph.replaceAll("\\p{Punct}", " ").toLowerCase().split("\\s+");
        String[] words = paragraph.replaceAll("\\pP", "").toLowerCase().split("\\s+");

        // String[] words = p.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        // \w is a word character, \W is a non-wor character

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


    // Good submission without using built-in string methods
    /*
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();
        String ans = "";
        int ansfreq = 0;
        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }
        return ans;
    }
    */
}

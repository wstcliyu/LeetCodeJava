import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;

public class Uncommon_888 {
    public String[] uncommonFromSentences(String A, String B) {
        // Good Submission
        // This is how to convert a list to an array
        // ans.toArray(new String[ans.size()])
        /*
        HashMap<String, Integer> count = new HashMap();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        LinkedList<String> ans = new LinkedList();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);
        return ans.toArray(new String[ans.size()]);
        */

        // My first solution, not very good
        HashMap<String, Integer> freq1 = new HashMap<>();
        HashMap<String, Integer> freq2 = new HashMap<>();
        String[] wA = A.split("\\s+");
        String[] wB = B.split("\\s+");
        ArrayList<String> res = new ArrayList<>();
        for (String a : wA)
            freq1.put(a, 1 + freq1.getOrDefault(a, 0));
        for (String b : wB)
            freq2.put(b, 1 + freq2.getOrDefault(b, 0));
        for (String a : freq1.keySet())
            if (freq1.get(a) == 1 && !freq2.containsKey(a))
                res.add(a);
        for (String b : freq2.keySet())
            if (freq2.get(b) == 1 && !freq1.containsKey(b))
                res.add(b);
        return res.toArray(new String[res.size()]);
    }
}

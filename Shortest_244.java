import java.util.*;

public class Shortest_244 {

    HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public Shortest_244(String[] words) {
        for(int i = 0; i < words.length; i++){
            // map.putIfAbsent(words[i], new ArrayList<>());
            // map.get(words[i]).add(i);
            map.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);

        int result = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(i < l1.size() && j < l2.size()) {
            result = Math.min(result, Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) < l2.get(j)) i++;
            else j++;
        }

        return result;
    }

}

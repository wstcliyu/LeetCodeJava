import java.util.*;

class Before_1181 {
    // Second voted solution: TreeSet
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, Set<String>> head = new HashMap<>();
        Map<String, Set<String>> tail = new HashMap<>();
        Map<String, Integer> freq = new HashMap<>();
        for (String phrase : phrases) {
            String[] a = phrase.split(" ");
            head.computeIfAbsent(a[0], k -> new HashSet<>()).add(phrase);
            tail.computeIfAbsent(a[a.length - 1], k -> new HashSet<>()).add(phrase);
            freq.put(phrase, 1 + freq.getOrDefault(phrase, 0));
        }
        
        TreeSet<String> res = new TreeSet<>();
        for (String t : tail.keySet()) {
            if (!head.containsKey(t)) continue;
            for (String first : tail.get(t)) {
                for (String second : head.get(t)) {
                    if (!second.equals(first) || freq.get(first) > 1)
                        res.add(first + second.substring(t.length()));
                }
            }
        }
        return new ArrayList<>(res);
    }



    // My solution
    /*
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, List<Integer>> tail = new HashMap<>();
        for (int i = 0; i < phrases.length; i++) {
            String p = phrases[i];
            int idx = p.lastIndexOf(' ');
            tail.computeIfAbsent(p.substring(idx + 1), k -> new ArrayList<>()).add(i);
        }
        
        TreeSet<String> res = new TreeSet<>();
        for (int i = 0; i < phrases.length; i++) {
            String p = phrases[i];
            int idx = p.indexOf(' ');
            String head = (idx == -1 ? p : p.substring(0, idx));
            String second = (idx == -1 ? "" : p.substring(idx));
            if (tail.containsKey(head)) {
                for (int j : tail.get(head)) {
                    if (i != j) {
                        res.add(phrases[j] + second);
                    }
                }
            }
        }
        
        return new ArrayList<>(res);
    }
    */
}
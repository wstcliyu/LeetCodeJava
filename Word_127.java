import java.util.*;

class Word_127 {
    // My biBFS template (also read 773, 752)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>(Arrays.asList(beginWord));
        Set<String> endSet = new HashSet<>(Arrays.asList(endWord));
        Set<String> dict = new HashSet<>(wordList);
        dict.remove(beginWord);
        dict.remove(endWord);
        int res = 2;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> t = beginSet;
                beginSet = endSet;
                endSet = t;
            }
            Set<String> next = new HashSet<>();
            for (String b : beginSet) {
                char[] chs = b.toCharArray();
                for (int i = 0; i < b.length(); i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chs[i] = c;
                        String s = new String(chs);
                        if (endSet.contains(s)) return res;
                        if (dict.contains(s)) {
                            next.add(s);
                            dict.remove(s);
                        }
                    }
                    chs[i] = old;
                }
            }
            beginSet = next;
            res++;
        }
        return 0;
    }



    // Good submission (very fast): Bidirectional BFS
    /*
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        
        Set<String> dict = new HashSet<>(wordList);
        
        return biBFS(beginSet, endSet, dict, 2);
    }

    private int biBFS(Set<String> beginSet, Set<String> endSet, Set<String> dict, int step) {
        if (beginSet.size() == 0) {
            return 0;
        } else if(beginSet.size() > endSet.size()) {
            return biBFS(endSet, beginSet, dict, step);
        }
        
        dict.removeAll(beginSet);
        dict.removeAll(endSet);
        
        Set<String> nextLevel = new HashSet<>();
        for (String word : beginSet) {
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char temp = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String candidate = String.valueOf(arr);
                    
                    if (endSet.contains(candidate)) 
                        return step;
                    if (dict.contains(candidate)) 
                        nextLevel.add(candidate);
                }
                arr[i] = temp;
            }
        }
        
        if (nextLevel.isEmpty()) return 0;
        
        return biBFS(nextLevel, endSet, dict, step + 1);
    }
    */



    // My solution using one-direction BFS
    /*
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        visited.add(endWord);
        Deque<String> q = new ArrayDeque<>();
        q.add(endWord);
        int res = 1;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String s1 = q.removeFirst();
                if (getDistance(s1, beginWord) == 1)
                    return res;
                for (String s2 : wordList) {
                    if (getDistance(s1, s2) == 1 && !visited.contains(s2)) {
                        visited.add(s2);
                        q.add(s2);
                    }
                }
            }
        }
        return 0;
    }
    
    private int getDistance(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        return count;
    }
    */
}
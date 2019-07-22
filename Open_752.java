import java.util.*;

class Open_752 {
    // Bi-directional BFS template (also refer to Word_127 for biBFS template)
    // I rewrite most voted solution
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        if (deads.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Set<String> beginSet = new HashSet<>(Arrays.asList("0000"));
        Set<String> endSet = new HashSet<>(Arrays.asList(target));
        return biBFS(beginSet, endSet, deads, 1);
    }
    
    private int biBFS(Set<String> beginSet, Set<String> endSet, Set<String> deads, int step) {
        if (beginSet.size() == 0) return -1;
        if (beginSet.size() > endSet.size()) return biBFS(endSet, beginSet, deads, step);

        deads.addAll(beginSet);
        deads.addAll(endSet);
        
        Set<String> nextSet = new HashSet<>();
        
        for (String s : beginSet) {
            for(int i = 0; i < 4; i ++) {
                char c = s.charAt(i);
                String s1 = s.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + s.substring(i + 1);
                String s2 = s.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + s.substring(i + 1);
                if (endSet.contains(s1) || endSet.contains(s2)) return step;
                if (!deads.contains(s1)) {
                    // deads.add(s1);
                    nextSet.add(s1);
                }
                if (!deads.contains(s2)) {
                    // deads.add(s2);
                    nextSet.add(s2);
                }
            }
        }
        
        return biBFS(nextSet, endSet, deads, step + 1);
    }



    // Most voted solution using BFS (from both ends to middle)
    /*
    public int openLock(String[] deadends, String target) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        begin.add("0000");
        end.add(target);
        int level = 0;
        Set<String> temp;
        while(!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                temp = begin;
                begin = end;
                end = temp;
            }
            temp = new HashSet<>();
            for(String s : begin) {
                if(end.contains(s)) return level;
                if(deads.contains(s)) continue;
                deads.add(s);
                StringBuilder sb = new StringBuilder(s);
                for(int i = 0; i < 4; i ++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if(!deads.contains(s1))
                        temp.add(s1);
                    if(!deads.contains(s2))
                        temp.add(s2);
                }
            }
            level ++;
            begin = temp;
        }
        return -1;
    }
    */



    // My first solution using BFS
    /*
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        if (deads.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.add("0000");

        int res = 0;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String s = q.removeFirst();
                for (int i = 0; i < 4; i++) {
                    String s1 = s.substring(0, i) + (s.charAt(i) - '0' + 1) % 10 + s.substring(i + 1);
                    if (s1.equals(target)) return res;
                    if (!deads.contains(s1) && !visited.contains(s1)) {
                        visited.add(s1);
                        q.add(s1);
                    }

                    String s2 = s.substring(0, i) + (s.charAt(i) - '0' + 9) % 10 + s.substring(i + 1);
                    if (s2.equals(target)) return res;
                    if (!deads.contains(s2) && !visited.contains(s2)) {
                        visited.add(s2);
                        q.add(s2);
                    }
                }
            }
        }
        return -1;
    }
    */
}
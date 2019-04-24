import java.util.*;

class Reorganize_767 {
    // Standard solution #1: Sort by Count
    // Time: O(N + AlgA), Space: O(N + A)
    // N is the length of S, A is the size of the Alphabet
    public String reorganizeString(String S) {
        int[] freq = new int[26];
        for (char c : S.toCharArray()) freq[c - 'a'] += 100;
        for (int i = 0; i < 26; i++) freq[i] += i;

        int N = S.length();
        Arrays.sort(freq);
        if (freq[25] / 100 > (N + 1) / 2) return "";
        
        char[] res = new char[N];
        int t = 1;
        for (int code : freq) {
            char ch = (char)('a' + code % 100);
            int ct = code / 100;
            for (int i = 0; i < ct; i++, t += 2) {
                if (t >= N) t = 0;
                res[t] = ch;
            }
        }
        
        return new String(res);
    }




    // Standard solution #2: Greedy by Heap
    // Time: O((N + A)lgA), Space: O(N + A)
    /*
    public String reorganizeString(String S) {
        int[] freq = new int[26];
        for (char c : S.toCharArray()) freq[c - 'a']++;
        PriorityQueue<MultiChar> pq = new PriorityQueue<>(Comparator.<MultiChar>comparingInt(m -> m.count).reversed().thenComparingInt(m -> m.letter));
        for (int i = 0; i < 26; i++) if (freq[i] > 0) pq.add(new MultiChar(freq[i], (char)('a' + i)));
        if (pq.peek().count > (S.length() + 1) / 2) return "";
        
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            MultiChar mc1 = pq.poll();
            MultiChar mc2 = pq.poll();
            sb.append(mc1.letter).append(mc2.letter);
            if (--mc1.count > 0) pq.add(mc1);
            if (--mc2.count > 0) pq.add(mc2);
        }

        if (pq.size() == 1) sb.append(pq.poll().letter);
        return sb.toString();
    }
    
    class MultiChar {
        int count;
        char letter;
        MultiChar(int _c, char _l) {
            count = _c;
            letter = _l;
        }
    }
    */
}
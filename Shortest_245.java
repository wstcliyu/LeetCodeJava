public class Shortest_245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) return shortestWordDistance(words, word1);
        int i1 = -1, i2 = -1;
        int res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
                if (i2 != -1) res = Math.min(res, i - i2);
            } else if (words[i].equals(word2)) {
                i2 = i;
                if (i1 != -1) res = Math.min(res, i - i1);
            }
        }
        return res;
    }

    public int shortestWordDistance(String[] words, String word) {
        int prev = -1;
        int res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                if (prev >= 0) {
                    res = Math.min(res, i - prev);
                }
                prev = i;
            }
        }
        return res;
    }
}

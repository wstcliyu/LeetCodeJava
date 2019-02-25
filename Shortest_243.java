public class Shortest_243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
                if (i2 != -1) res = Math.min(res, i1 - i2);
            } else if (words[i].equals(word2)) {
                i2 = i;
                if (i1 != -1) res = Math.min(res, i1 - i2);
            }
        }
        return res;
    }
}

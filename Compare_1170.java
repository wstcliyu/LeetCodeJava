import java.util.Arrays;

class Compare_1170 {
    // My first solution
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] fw = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            fw[i] = getFreqOfSmallest(words[i]);
        }
        Arrays.sort(fw);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int target = getFreqOfSmallest(queries[i]);
            res[i] = words.length - binarySearch(target, fw);
        }
        return res;
    }
    
    private int binarySearch(int target, int[] fw) {
        int l = 0, r = fw.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (fw[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
    
    private int getFreqOfSmallest(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray())
            freq[c - 'a']++;
        for (int i = 0; i < 26; i++)
            if (freq[i] > 0)
                return freq[i];
        return 0;
    }
}
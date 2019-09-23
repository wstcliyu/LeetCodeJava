import java.util.ArrayList;
import java.util.List;

class Text_68 {
    // Second voted solution
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<>();
        int N = words.length;
        for (int i = 0, k, l; i < N; i += k) {
            for (k = l = 0; i + k < N && l + words[i + k].length() <= L - k; k++) {
                l += words[i + k].length();
            }
            StringBuilder sb = new StringBuilder(words[i]);
            // If k == 1, it means there is only 1 word in this line
            // So the following loop will not execute
            // This line will be left justified
            for (int j = 0; j < k - 1; j++) {
                if (i + k == N) {
                    // The last line must be left justified
                    sb.append(' ');
                } else {
                    int q = (L - l) / (k - 1);
                    int r = (L - l) % (k - 1);
                    for (int z = 0; z < q + (j < r ? 1 : 0); z++) {
                        sb.append(' ');
                    }
                }
                
                sb.append(words[i + j + 1]);
            }
            while (sb.length() < L)
                sb.append(' ');
            res.add(sb.toString());
        }
        return res;
    }
}
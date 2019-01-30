public class CountSubstringWithKDistinct {
    // Amazon OA 2: Count the number of substrings with k distinct elements
    public int countkDist(String str, int k) {
        int res = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[26];
            for (int j = i, count = 0; j < n && count <= k; j++) {
                int c = str.charAt(j) - 'a';
                if (!seen[c]) {
                    count++;
                    seen[c] = true;
                }
                if (count == k) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountSubstringWithKDistinct test = new CountSubstringWithKDistinct();
        System.out.println(test.countkDist("pqpqs", 2));
    }
}

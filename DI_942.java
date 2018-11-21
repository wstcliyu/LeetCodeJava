public class DI_942 {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int left = 0, right = N;
        int[] res = new int[N + 1];
        for (int i = 0; i < N; i++)
            res[i] = S.charAt(i) == 'I' ? left++ : right--;
        res[N] = left;
        return res;
    }
}

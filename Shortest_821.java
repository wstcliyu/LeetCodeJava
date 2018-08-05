import java.util.ArrayList;

public class Shortest_821 {
    public int[] shortestToChar(String S, char C) {
        // Standard solution, better organized than mine
        /*
        int N = S.length();
        int[] ans = new int[N];

        int prev = Integer.MIN_VALUE / 2;
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
        */

        // My first solution
        int len = S.length();
        int[] res = new int[len];
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(-len);
        for (int i=0; i<len; i++)
            if (S.charAt(i) == C) ls.add(i);
        ls.add(Integer.MAX_VALUE);
        int j = 1;
        for (int i=0; i<len; i++) {
            if (i > ls.get(j))
                j++;
            res[i] = Math.min(i - ls.get(j-1), ls.get(j) - i);
        }
        return res;
    }
}

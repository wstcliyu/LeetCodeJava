import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Positions_830 {
    public static List<List<Integer>> largeGroupPositions(String S) {
        /* Most voted solution, better than mine
        int i = 0, j = 0, N = S.length();
        List<List<Integer>> res = new ArrayList<>();
        while (j < N) {
            while (j < N && S.charAt(j) == S.charAt(i)) ++j;
            if (j - i >= 3) res.add(Arrays.asList(i, j - 1));
            i = j;
        }
        return res;
        */

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int cur = 0;
        int n = S.length();
        int left, right;
        while (cur<n) {
            if (cur+2<n && S.charAt(cur)==S.charAt(cur+1) && S.charAt(cur)==S.charAt(cur+2)) {
                left = cur;
                right = cur + 2;
            }
            else {
                cur++;
                continue;
            }
            int i = right;
            for (; i<n; i++) {
                if (S.charAt(i) != S.charAt(left))
                    break;
            }
            right = i-1;
            result.add(Arrays.asList(left,right));
            cur = right + 1;
        }
        return result;
    }
    public static void main (String args[]) {
        String testString = "abcdddeeeeaabbbcd";
        System.out.println(largeGroupPositions(testString));
    }
}

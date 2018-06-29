import java.util.List;

public class Pyramid_756 {
    int[][] T = new int[7][7];
    // Try every possible circumstance, not sure about the time complexity
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String a:allowed)
            T[a.charAt(0)-'A'][a.charAt(1)-'A'] |= 1<<(a.charAt(2)-'A');
        int N = bottom.length();
        int[][] A = new int[N][N];
        for (int i=0; i<N; i++)
            A[N-1][i] = bottom.charAt(i) - 'A';
        return solve(A, N-1, 0);
    }
    // A[i] - the ith row of the pyramid
    // N - length of current row we are calculating
    // i - index of how far in the current row we are calculating
    private boolean solve(int[][] A, int N, int i) {
        if (N == 1 && i == 1) // If successfully placed entire pyramid
            return true;
        else if (i == N)
            return solve(A, N-1, 0); // Move to next row
        else {
            int w = T[A[N][i]][A[N][i+1]];
            for (int b=0; b<7; b++) if ((w & (1<<b)) != 0) {
                A[N-1][i] = b;
                // If rest of pyramid can be built, return true
                if (solve(A, N, i+1))
                    return true;
            }
            return false;
        }
    }
}
// Most voted solution
/*
class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0,2);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s.substring(2));
        }

        return helper(bottom, map);
    }

    private boolean helper(String bottom, Map<String, List<String>> map) {
        if(bottom.length() == 1) return true;
        for (int i = 0; i<bottom.length()-1; i++) {
            if (!map.containsKey(bottom.substring(i,i+2))) return false;
        }
        List<String> ls = new ArrayList<>();
        getList(bottom, 0, new StringBuilder(), ls, map);
        for (String s : ls) {
            if (helper(s, map)) return true;
        }
        return false;
    }
    // getList() add all the possible upper row of bottom to ls
    // the length of the strings in ls is less than bottom by 1
    private void getList(String bottom, int idx, StringBuilder sb, List<String> ls, Map<String, List<String>> map) {
        if (idx == bottom.length() - 1) {
            ls.add(sb.toString());
            return;
        }
        for (String s : map.get(bottom.substring(idx, idx+2))) {
            sb.append(s);
            getList(bottom, idx + 1, sb, ls, map);
            // clear sb after add sb.toString() to ls
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
*/
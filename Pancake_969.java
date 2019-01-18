import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pancake_969 {
    // My solution (similar with standard)
    /*
    public List<Integer> pancakeSort(int[] A) {
        ArrayList<Integer> res = new ArrayList<>();
        int N = A.length;
        int[] index = new int[N + 1];
        for (int i = 0; i < N; i++)
            index[A[i]] = i + 1;
        for (int i = N; i > 0; i--) {
            for (int f : res)
                if (index[i] <= f)
                    index[i] = f + 1 - index[i];
            if (index[i] != i) {
                res.add(index[i]);
                res.add(i);
            }
        }
        return res;
    }
    */

    // Standard solution
    /*
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList();
        int N = A.length;

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i+1;
        Arrays.sort(B, (i, j) -> A[j-1] - A[i-1]);

        for (int i: B) {
            for (int f: ans)
                if (i <= f)
                    i = f+1 - i;
            ans.add(i);
            ans.add(N--);
        }

        return ans;
    }
    */


    // Most voted solution
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int x = A.length, i; x > 0; --x) {
            for (i = 0; A[i] != x; ++i);
            reverse(A, i + 1);
            res.add(i + 1);
            reverse(A, x);
            res.add(x);
        }
        return res;
    }

    public void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations_77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 1, n, k);
        return res;
    }
    private static void helper(List<List<Integer>> ls, List<Integer> tempList, int start, int n, int k) {
        int len = tempList.size();
        if (len == k)
            ls.add(new ArrayList<>(tempList));
        else {
            for (int i=start; i<=n-k+len+1; i++) {
                tempList.add(i);
                helper(ls, tempList, i+1, n, k);
                tempList.remove(len);
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> res = combine(4,2);
        for (List<Integer> i:res) {
            System.out.println(Arrays.toString(i.toArray()));
        }
    }
}

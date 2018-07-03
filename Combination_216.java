import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 1, k, n);
        return res;
    }
    private static void helper(List<List<Integer>> ls, List<Integer> tempList, int start, int k, int target) {
        if (tempList.size() == k) {
            if (target == 0)
                ls.add(new ArrayList<>(tempList));
        }
        else {
            for (int i=start; i<=Math.min(target, 9); i++) {
                tempList.add(i);
                helper(ls, tempList, i+1, k, target-i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3,9);
        for (List<Integer> i:res) {
            System.out.println(Arrays.toString(i.toArray()));
        }
    }
}

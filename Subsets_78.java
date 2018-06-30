import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private static void backtrack(List<List<Integer>> ls, List<Integer> tmp, int[] nums, int start) {
        ls.add(new ArrayList<>(tmp));
        for (int i=start; i<nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(ls, tmp, nums, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] testNums = {3,1,2};
        List<List<Integer>> res = subsets(testNums);
        for (List<Integer> i:res) {
            System.out.println(Arrays.toString(i.toArray()));
        }
    }
}

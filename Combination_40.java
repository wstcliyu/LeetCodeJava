import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }
    private static void helper(List<List<Integer>> ls, List<Integer> tempList, int[] nums, int start, int target) {
        if (target < 0)
            return;
        else if (target == 0)
            ls.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                if(i > start && nums[i] == nums[i-1])
                    continue;
                tempList.add(nums[i]);
                helper(ls, tempList, nums, i+1, target - nums[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

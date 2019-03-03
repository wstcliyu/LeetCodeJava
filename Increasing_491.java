import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Increasing_491 {
    // Most voted solution using backtrack
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, new LinkedList<>(), 0, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, LinkedList<Integer> tmp, int index, int[] nums) {
        if (tmp.size() > 1)
            res.add(new LinkedList<>(tmp));
        HashSet<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            // if ((i > index && nums[i] == nums[i-1]) || (!tmp.isEmpty() && nums[i] < tmp.getLast())) continue;
            // The code above is incorrect because nums is not sorted
            if (used.contains(nums[i]) || (!tmp.isEmpty() && nums[i] < tmp.getLast())) continue;
            used.add(nums[i]);
            tmp.addLast(nums[i]);
            backtrack(res, tmp, i+1, nums);
            tmp.removeLast();
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }
    private static void helper(List<List<Integer>> ls, List<Integer> tempList, int[] nums, int start, int target) {
        if(target < 0)
            return;
        else if(target == 0)
            ls.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                helper(ls, tempList, nums, i, target - nums[i]); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
        // My solution similar as most voted, also very good
        /*
        for (int i=start; i<nums.length && nums[i]<=target; i++) {
            tempList.add(nums[i]);
            if (nums[i] == target) {
                ls.add(new ArrayList<>(tempList));
                // Remark: Can not return;
                // Because we need to remove the last element of tempList
            }
            helper(ls, tempList, nums, i, target-nums[i]);
            tempList.remove(tempList.size()-1);
        }
        */
    }
    public static void main(String[] args) {
        int[] testCandidates = {2,3,5};
        List<List<Integer>> res = combinationSum(testCandidates,8);
        for (List<Integer> i:res) {
            System.out.println(Arrays.toString(i.toArray()));
        }
    }
}

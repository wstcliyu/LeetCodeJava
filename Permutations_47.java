import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    private static void backtrack(List<List<Integer>> ls, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length)
            ls.add(new ArrayList<>(tempList));
        else {
            for (int i=0; i<nums.length; i++) {
                if (used[i])
                    continue;
                if (i>0 && nums[i]==nums[i-1] && !used[i-1])
                    continue;
                tempList.add(nums[i]);
                used[i] = true;
                backtrack(ls, tempList, nums, used);
                tempList.remove(tempList.size()-1);
                used[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int[] testNums = {4,1,1};
        List<List<Integer>> res = permuteUnique(testNums);
        for (List<Integer> i:res) {
            System.out.println(Arrays.toString(i.toArray()));
        }
    }
}

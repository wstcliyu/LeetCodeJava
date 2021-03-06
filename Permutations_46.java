import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Permutations_46 {
    // Third voted solution (Iterative DP)
    // Insert nums[k+1] into every possible position of the permutations of first k elements
    // Why it is not slow ? Because the sum of k! (k=1,...,n) is still O(n!)
    /*
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length == 0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i< num.length; ++i){
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
            for (int j = 0; j<=i; ++j){
               for (List<Integer> l : ans){
                   List<Integer> new_l = new ArrayList<Integer>(l);
                   new_l.add(j,num[i]);
                   new_ans.add(new_l);
               }
            }
            ans = new_ans;
        }
        return ans;
    }
    */



    // Most voted solution
    /*
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }
    private static void backtrack(List<List<Integer>> ls, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length)
            ls.add(new ArrayList<>(tempList));
        else {
            for (int i=0; i<nums.length; i++) {
                if (tempList.contains(nums[i]))
                    continue;
                tempList.add(nums[i]);
                backtrack(ls, tempList, nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    */



    // Rewrite most voted solution
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), new boolean[nums.length], nums);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> tmp, boolean[] used, int[] nums) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                tmp.add(nums[i]);
                used[i] = true;
                helper(res, tmp, used, nums);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }



    // Second voted solution (Exchange the elements in array)
    // Very slow because of stream ?
    /*
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, 0, nums);
        return res;
    }

    private static void helper(List<List<Integer>> ls, int start, int[] nums) {
        if (start == nums.length) {
            List<Integer> t = Arrays.stream(nums).boxed().collect(Collectors.toList());
            ls.add(t);
        }
        else {
            for (int i=start; i<nums.length; i++) {
                swap(i, start, nums);
                helper(ls, start+1, nums);
                swap(i, start, nums);
            }
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] testNums = {4,2,1};
        List<List<Integer>> res = permute(testNums);
        for (List<Integer> i:res) {
            System.out.println(Arrays.toString(i.toArray()));
        }
    }
    */
}

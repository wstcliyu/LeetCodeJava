import java.util.Arrays;

public class Matchsticks_473 {
    /*
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 4 != 0)
            return false;
        Arrays.sort(nums);
        reverseArray(nums);
        return dfs(nums, sum/4, new int[4], 0);
    }
    private void reverseArray(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
    private boolean dfs(int[] nums, int target, int[] temp, int index) {
        if (index == nums.length)
            return temp[0] == target && temp[1] == target && temp[2] == target;

        for (int i=0; i<4; i++) {
            if (temp[i] + nums[index] > target)
                continue;
            temp[i] += nums[index];
            if (dfs(nums, target, temp, index+1))
                return true;
            temp[i] -= nums[index];
        }
        return false;
    }
    */

    // Solution from acwing community
    int side;
    boolean[] st;
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4)
            return false;
        int sum = 0;
        for (int i:nums)
            sum += i;
        side = sum / 4;
        if (sum % 4 != 0)
            return false;
        st = new boolean[nums.length];
        Arrays.sort(nums);
        return dfs(nums, side, 0, 0);
    }

    private boolean dfs(int[] nums, int target, int count, int start) {
        if (target == 0) {
            count ++ ;
            if (count == 4)
                return true;
            return dfs(nums, side, count, 0);
        }
        for (int i = start; i < nums.length; i ++ )
            if (!st[i] && target >= nums[i]) {
                if (i>0 && !st[i - 1] && nums[i] == nums[i - 1])
                    continue; // Pruning 1
                st[i] = true;
                if (dfs(nums, target - nums[i], count, i + 1))
                    return true;
                st[i] = false;
                if (target == nums[i] || target == side)
                    return false; // Pruning 2
            }
        return false;
    }
    public static void main (String args[]) {
        Matchsticks_473 test = new Matchsticks_473();
        int[] testNums = {13, 11, 1, 8, 6 , 7 , 8 ,8, 6 , 7 , 8 ,9, 8};
        System.out.println(test.makesquare(testNums));
    }
}

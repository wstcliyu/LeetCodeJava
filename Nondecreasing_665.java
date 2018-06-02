public class Nondecreasing_665 {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                count++;
                if (count > 1)
                    return false;
                if (i == nums.length-2 || i == 0)
                    continue;
                if (nums[i+2] < nums[i] && nums[i+1] < nums[i-1])
                    return false;
            }
        }
        return true;
    }
}

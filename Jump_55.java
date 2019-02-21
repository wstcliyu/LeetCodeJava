public class Jump_55 {
	// My solution (also can solve Jump_45)
	public boolean canJump(int[] nums) {
        int i = 0, pre_max, cur_max = 0;
        do {
            pre_max = cur_max;
            for (; i <= pre_max; i++)
                cur_max = Math.max(cur_max, i + nums[i]);
        } while (pre_max < cur_max && cur_max < nums.length - 1);
        return cur_max >= nums.length - 1;
    }


	// Online solution
	/*
	public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
	*/
}
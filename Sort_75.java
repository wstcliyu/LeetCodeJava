public class Sort_75 {
    // My updated solution
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) swap(nums, i, left++);
            else if (nums[i] == 2) swap(nums, i--, right--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    // My first solution
    /*
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0 && i != left) swap(nums, i--, left++);
            else if (nums[i] == 2 && i != right) swap(nums, i--, right--);
        }
    }

    // This way for swap must require i != j
    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
    */
}

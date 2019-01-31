public class Sort_75 {
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
}

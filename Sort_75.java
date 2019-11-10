public class Sort_75 {
    // Most voted solution
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        for (int k = 0; k <= j; k++) {
            while (nums[k] == 2 && k < j) swap(nums, k, j--);
            while (nums[k] == 0 && k > i) swap(nums, k, i++);
        }
    }



    // My updated solution
    /*
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
    */



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

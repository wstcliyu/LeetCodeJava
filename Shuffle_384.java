import java.util.Arrays;
import java.util.Random;

class Shuffle_384 {
    // Standard solution #2
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }



    // My first solution (similar with standard solution #2)
    /*
    int[] restore, nums;

    public Solution(int[] nums) {
        restore = Arrays.copyOf(nums, nums.length);
        this.nums = nums;
    }
    
    public int[] reset() {
        return restore;
    }
    
    public int[] shuffle() {
        Random rand = new Random();
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int j = i + rand.nextInt(N - i);
            if (i != j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return nums;
    }
    */
}

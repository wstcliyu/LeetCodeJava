import java.util.Random;

class Random_398 {
    // Most voted solution using reservoir sampling
    // Similar with Linked_382
    
    int[] nums;
    Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int res = -1, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            if (rand.nextInt(++count) == 0) res = i;
        } 
        return res;
    }
}
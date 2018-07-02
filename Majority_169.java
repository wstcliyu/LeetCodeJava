import java.util.Arrays;
import java.util.Random;

public class Majority_169 {
    // Standard solution #3 (Sorting)
    // Time O(nlogn) Space O(1) or O(n)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    // Standard solution #4 (Randomization)
    // Time O(infinity), Expected time is 2, Space O(1)
    /*
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num)
                count++;
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length/2;
        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount)
                return candidate;
        }
    }
    */


    // Standard solution #6 (Boyer-Moore Voting Algorithm)
    // Time O(n) Space O(1)
    /*
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    */


    // Standard solution #5 (Divide and Conquer)
    // Time O(nlogn) T(n) = 2T(n/2) + 2n
    // Space O(logn)
    /*
    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
    */

    /*
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
    */
}

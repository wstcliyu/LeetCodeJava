public class Rotate_189 {
    // Standard Approach #2: Using Extra Array
    /*
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
    */

    // Standard Approach #4: Using Reverse
    /*
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    */

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;
        for(int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[current];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while(current != start);
        }
    }

    public static void main (String args[]) {
        int[] testNums = {1,2,3,4,5,6};
        int testK = 2;
        rotate(testNums, testK);
        for (int i=0; i<testNums.length; i++)
            System.out.print(testNums[i]+" ");
    }
}

public class Rotate_189 {
    public static void rotate(int[] nums, int k) {

        /** My solution using extra array
        int n = nums.length;
        k = k%n;
        if(k == 0)
            return;
        int[] temp = new int[n];
        for (int i=0;i<n;i++)
            temp[i] = nums[i];
        for (int i=0; i<n-k; i++)
            nums[i+k] = temp[i];
        for (int j=0; j<k; j++)
            nums[j] = temp[j+n-k];
        */

        /** Using extra array(similar but better than mine)
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
        */

        int n = nums.length;
        k = k%n;
        int count = 0;
        int prev, temp;
        for(int start=0; count<n; start++) {
            int current = start;
            prev = nums[current];
            do {
                int next = (current+k)%n;
                temp = nums[next];
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

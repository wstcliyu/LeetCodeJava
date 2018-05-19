import java.util.Arrays;

public class Beautiful_667 {
    public static int[] constructArray(int n, int k) {
        int[] result = new int[n];
        for (int i=0; i<n-k-1; i++)
            result[i] = i+1;
        int temp = 0;
        for (int i=n-k-1; i<n; i++, temp++)
            result[i] = (temp%2 == 0) ? temp/2 + n-k: n - temp/2;
        return result;
    }
    public static void main (String args[]) {
        System.out.println(Arrays.toString(constructArray(3,2)));
    }
}

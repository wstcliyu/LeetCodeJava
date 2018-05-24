import java.util.Arrays;

public class FourSum_454 {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // Sort two arrays, then use two pointers. this problem may also be solved by HashMap
        int n = A.length;
        int[] AB = new int[n*n];
        int[] CD = new int[n*n];
        int i = 0;
        for (int a:A) {
            for (int b:B)
                AB[i++] = a+b;
        }
        i = 0;
        for (int c:C) {
            for (int d:D)
                CD[i++] = c+d;
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
        int res = 0;
        i = 0;
        int j = n*n-1;
        while (i<n*n && j>=0) {
            int sum = AB[i]+CD[j];
            if (sum > 0)
                j--;
            else if (sum < 0)
                i++;
            else {
                int anchor_i = i;
                int anchor_j = j;
                while (i<n*n-1 && AB[i]==AB[i+1])
                    i++;
                while (j>0 && CD[j]==CD[j-1])
                    j--;
                res += (i++ - anchor_i + 1)*(anchor_j - j-- + 1);
            }
        }
        return res;
    }
    public static void main (String args[]) {
        int[] testA= {1,2};
        int[] testB= {-2,-1};
        int[] testC= {-1,2};
        int[] testD= {0,2};
        System.out.println(fourSumCount(testA, testB, testC, testD));
    }
}

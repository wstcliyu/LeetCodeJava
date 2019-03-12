import java.util.Arrays;

public class Next_556 {
	// My first solution
	// similar with Next_31
	/*
    public int nextGreaterElement(int n) {
        int[] A = intToArray(n);
        int start = 0;
        while (A[start] == 0) start++;
        
        int i = A.length - 2;
        while (i >= start && A[i] >= A[i+1]) i--;
        if (i < start) return -1;
        
        int j = A.length - 1;
        while (A[j] <= A[i]) j--;
        swap(A, i, j);
        reverse(A, i + 1);
        
        int[] B = intToArray(Integer.MAX_VALUE);
        return compareArr(A, B) > 0 ? -1 : arrayToInt(A);
    }
    
    
    private void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
    
    private void reverse(int[] A, int start) {
        int i = start, j = A.length - 1;
        while (i < j) swap(A, i++, j--);
    }
    
    private int[] intToArray(int n) {
        int[] digit = new int[10];
        for (int i = 9; i >= 0 && n > 0; i--) {
            digit[i] = n % 10;
            n /= 10;
        }
        return digit;
    }
    
    private int arrayToInt(int[] digit) {
        int res = 0;
        for (int i = 0; i < 10; i++)
            res = res * 10 + digit[i];
        return res;
    } 
    
    private int compareArr(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] < b[i]) return -1;
            else if (a[i] > b[i]) return 1;
            else continue;
        }
        return 0;
    }
    */



    // Most voted solution
    public int nextGreaterElement(int n) {
        char[] number = (n + "").toCharArray();
        
        int i, j;
        // I) Start from the right most digit and 
        // find the first digit that is
        // smaller than the digit next to it.
        for (i = number.length-1; i > 0; i--)
            if (number[i-1] < number[i])
               break;

        // If no such digit is found, its the edge case 1.
        if (i == 0) return -1;
            
         // II) Find the smallest digit on right side of (i-1)'th 
         // digit that is greater than number[i-1]
        int x = number[i-1], smallest = i;
        for (j = i+1; j < number.length; j++)
            if (number[j] > x && number[j] <= number[smallest])
                smallest = j;
        
        // III) Swap the above found smallest digit with 
        // number[i-1]
        char temp = number[i-1];
        number[i-1] = number[smallest];
        number[smallest] = temp;
        
        // IV) Sort the digits after (i-1) in ascending order
        Arrays.sort(number, i, number.length);
        
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
}
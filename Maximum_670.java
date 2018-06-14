import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Maximum_670 {
    public static int maximumSwap(int num) {
        /* Most voted solution
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num;
        */
        ArrayList<Integer> digit = new ArrayList<>();
//        ArrayList<Point> maxDigit = new ArrayList<>();
        ArrayList<Integer> maxDigit = new ArrayList<>();
        int max = 0, maxIndex = 0, swapCount = 0, res = 0;
        for (int i=0; num>0; i++) {
            digit.add(num % 10);
            if (max < num % 10) {
                max = num % 10;
                maxIndex = i;
            }
//            maxDigit.add(new Point(maxIndex, max));
            maxDigit.add(maxIndex);
            num /= 10;
        }
        for (int i=digit.size()-1; i>=0; i--) {
//            if (swapCount < 1 && i != maxDigit.get(i).x) {
//                Collections.swap(digit, i, maxDigit.get(i).x);
            if (swapCount < 1 && digit.get(i) < digit.get(maxDigit.get(i))) {
                Collections.swap(digit, i, maxDigit.get(i));
                swapCount++;
            }
            res = res * 10 + digit.get(i);
        }
        return res;
        /* My first solution which is wrong because swap at most once
        ArrayList<Integer> digit = new ArrayList<>();
        while(num > 0) {
            digit.add(num % 10);
            num /= 10;
        }
        Collections.sort(digit, (a,b) -> b-a);
        int res = 0;
        for (int d:digit)
            res = res * 10 + d;
        return res;
        */

    }
    public static void main (String[] args) {
        int testNum = 1993;
        System.out.println(maximumSwap(testNum));
    }
}

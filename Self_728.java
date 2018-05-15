import java.util.ArrayList;
import java.util.List;

public class Self_728 {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        // get each digit of an integer with consecutive division by 10
        List<Integer> result = new ArrayList<Integer>();
        for (int num=left; num<=right; num++) {
            int temp = num;
            while (temp>0) {
                int divider = temp%10;
                if (divider == 0)
                    break;
                if (num%divider == 0)
                    temp /= 10;
                else break;
            }
            if (temp == 0)
                result.add(num);
        }
        return result;


        /** Convert integer to string, longer runtime
        List<Integer> result = new ArrayList<Integer>();
        for (int num=left; num<=right; num++) {
            String temp = Integer.toString(num);
            int i;
            for (i=0; i<temp.length(); i++) {
                int divider = temp.charAt(i)-'0';
                if (divider == 0 || num%divider != 0)
                    break;
            }
            if( i == temp.length())
                result.add(num);
        }
        return result;
        */
    }
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1,22));
    }
}

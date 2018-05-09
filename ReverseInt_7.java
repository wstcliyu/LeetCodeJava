public class ReverseInt_7 {
    public static int reverse(int x) {
        int result = 0, temp;
        while (x != 0) {
            temp = result;
            result = result*10+x%10;
            /** Most Voted Solution
             if ((result-x%10)/10 != temp)
             return 0;
             */
            x = x/10;
            temp = Math.abs(temp);
            if (Integer.MAX_VALUE/10 < temp)
                return 0;
            if (Integer.MAX_VALUE/10 == temp) {
                /** Integer.MAX_VALUE == Math.pow(2,31)-1 == 2147483647 final digit is 7
                 Integer.MIN_VALUE == -Math.pow(2,31) == -2147483648 final digit is 8
                 */
                if (result > 0 && x > 7)
                    return 0;
                if (result < 0 && x > 8)
                    return 0;
            }
        }
        return result;
    }
    public static void main (String args[]) {
        System.out.println(reverse(1234567));
    }
}

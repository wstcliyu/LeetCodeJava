public class String_8 {
    public int myAtoi(String str) {
        if (str.length() == 0) return 0;
        int i = 0, sum = 0, sign = 1;

        while (i < str.length() && str.charAt(i) == ' ') i++;

        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < str.length()) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9)
                break;
            if (sign == 1 && (sum > Integer.MAX_VALUE/10 || sum == Integer.MAX_VALUE/10 && digit > 7))
                return Integer.MAX_VALUE;
            if (sign == -1 && (sum > Integer.MAX_VALUE/10 || sum == Integer.MAX_VALUE/10 && digit > 8))
                return Integer.MIN_VALUE;
            sum = sum * 10 + digit;
            i++;
        }

        return sum * sign;
    }
}

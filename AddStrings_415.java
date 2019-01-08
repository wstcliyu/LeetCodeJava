public class AddStrings_415 {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int carry = 0;
        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            if (n1 >= 0)
                carry += num1.charAt(n1--) - '0';
            if (n2 >= 0)
                carry += num2.charAt(n2--) - '0';
            // Be careful to use (a + b + carray) % 10 instead of a + b + carray % 10
            result.insert(0, carry % 10);
            // Be careful to use (a + b + carray) / 10 instead of a + b + carray / 10
            carry /= 10;
        }
        return result.toString();
    }
    public static void main (String args[]) {
        System.out.println(addStrings("1", "9"));
    }
}

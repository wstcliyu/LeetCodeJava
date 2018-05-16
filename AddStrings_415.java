public class AddStrings_415 {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int n1 = num1.length()-1;
        int n2 = num2.length()-1;
        int carry = 0;
        while (n1>=0 || n2>=0 || carry>0) {
            int a = 0, b = 0;
            if (n1>=0)
                a = num1.charAt(n1--) - '0';
            if (n2>=0)
                b = num2.charAt(n2--) - '0';
            result.append(a+b+carry>9 ? a+b+carry-10 : a+b+carry);
            carry = a+b+carry>9 ? 1 : 0;
        }
        return result.reverse().toString();
    }
    public static void main (String args[]) {
        System.out.println(addStrings("1", "9"));
    }
}

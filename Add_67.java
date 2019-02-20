public class AddBinary_67 {
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || sum > 0) {
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum%2);
            sum = sum/2;
        }
        return result.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
    }
}

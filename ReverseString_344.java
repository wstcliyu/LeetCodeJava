public class ReverseString_344 {
    public static String reverseString(String s) {
        /*
        StringBuilder result = new StringBuilder();
        for (int i=0; i<s.length(); i++)
            result.insert(0,s.charAt(i));
        return result.toString();
        */
        StringBuilder result = new StringBuilder(s);
        return result.reverse().toString();

    }
    public static void main(String[] args) {
        String tests = "Hello";
        System.out.println(reverseString(tests));
    }
}

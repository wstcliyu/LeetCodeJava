public class Excel_168 {
    public static String convertToTitle(int n) {

        /** Iterative method

        String result = "";
        while (n>0) {
            char temp = (char)((--n)%26 + 'A');
            result = temp + result;
            n = n/26;
        }
        return result;

        */

        /**
         * Recursive method
         */
        if (n == 0)
            return "";
        return convertToTitle(--n/26)+(char)(n%26+'A');
    }
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}

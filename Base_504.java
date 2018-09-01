public class Base_504 {


    // Most voted solution using recursion
    public String convertToBase7(int num) {
        // Good submission
        // return Integer.toString(num, 7);
        if (num < 0)
            return '-' + convertToBase7(-num);
        if (num < 7)
            return num + "";
        return convertToBase7(num / 7) + num % 7;
    }

    // My first solution using iteration
    /*
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        if (num < 0)
            return "-" + convertToBase7(-num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }
        return sb.toString();
    }
    */
}

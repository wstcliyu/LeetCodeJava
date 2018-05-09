public class Excel_171 {
    public static int titleToNumber(String s) {
        if (s == null) return 0;
        int temp,result=0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            temp = c-64;
            result = result*26 + temp;
        }
        return result;
    }

    public static void main (String args[]) {
        System.out.println(titleToNumber("AB"));
    }
}
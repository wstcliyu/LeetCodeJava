public class Count_38 {
    public static String countAndSay(int n) {
        if (n == 1)
            return "1";
        String prev = countAndSay(n-1);
        StringBuilder cur = new StringBuilder();
        int i = 0;
        while (i < prev.length()) {
            int count = 0;
            char say = prev.charAt(i);
            while (i < prev.length() && prev.charAt(i) == say) {
                count++;
                i++;
            }
            cur.append(count).append(say);
        }
        return cur.toString();
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}

public class CountBinarySubstrings_696 {
    public static int countBinarySubstrings(String s) {
        int count = 0;
        int consecutive = 0;
        int n = s.length();
        int i = 0;
        while(i<n) {
            int j = i;
            while (j<n && s.charAt(j)==s.charAt(i))
                j++;
            count += Math.min(j-i, consecutive);
            if (j == n)
                break;
            consecutive = j-i;
            i = j;
        }
        return count;
    }
    public static void main (String args[]) {
        String testS = "00110011";
        System.out.println(countBinarySubstrings(testS));
    }
}

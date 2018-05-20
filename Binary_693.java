public class Binary_693 {
    public static boolean hasAlternatingBits(int n) {
        // This problem has many solutions. Refer to leetcode website.
        int first = 31;
        while (first >= 0) {
            if (getBit(n,first))
                break;
                first--;
        }
        for (int i=first; i>0; i--) {
            if (getBit(n,i) == getBit(n,i-1))
                return false;
        }
        return true;
    }
    public static boolean getBit(int n, int i) {
        return ((1<<i) & n) != 0;
    }

    public static void main (String args[]) {
        int testNum = 7;
        System.out.println(hasAlternatingBits(testNum));
    }
}

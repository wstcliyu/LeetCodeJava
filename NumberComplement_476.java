public class NumberComplement_476 {
    public static int findComplement(int num) {
        int first=0;
        for (int i=31; i>=0; i--) {
            if (((1<<i) & num) != 0) {
                first = i;
                break;
            }
        }
        return (~num) & ((1<<first)-1);
    }
    public static void main (String args[]) {
        int testNum = 1;
        System.out.println(findComplement(testNum));
    }
}

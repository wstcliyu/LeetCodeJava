public class Characters_717 {
    public static boolean isOneBitCharacter(int[] bits) {
        /* Approach #2: Greedy
         * O(n) O(1)
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) i--;
        return (bits.length - i) % 2 == 0;
        */

        // Approach #1: Increment Pointer
        // O(n) O(1)
        int n = bits.length;
        int i = 0;
        while (i <= n-2) {
            i += 1 + bits[i];
        }
        return i == n-1;
    }
    public static void main (String args[]) {
        int[] testBits = {1,1,1,0};
        System.out.println(isOneBitCharacter(testBits));
    }
}

public class CanPlaceFlower_605 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev, next, current;
        prev = 0;
        int l = flowerbed.length;
        for (int i=0; i<l; i++) {
            current = flowerbed[i];
            next = (i == l-1) ? 0 : flowerbed[i+1];
            if (prev == 0 && current == 0 && next == 0) {
                n -= 1;
                current = 1;
            }
            prev = current;
        }
        return n<=0;
    }
    public static void main(String[] args) {
        int[] testNums = {1,0,0,0,1};
        System.out.println(canPlaceFlowers(testNums,1));
    }
}

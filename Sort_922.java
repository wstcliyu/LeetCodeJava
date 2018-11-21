public class Sort_922 {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0, odd = 0;
        int[] res = new int[A.length];
        for (int a : A) {
            if (a % 2 == 0)
                res[2 * even++] = a;
            else
                res[1 + 2 * odd++] = a;
        }
        return res;
    }
}

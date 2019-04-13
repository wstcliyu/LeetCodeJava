class Elimination_390 {
    // Most voted solution
    public int lastRemaining(int n) {
        boolean leftToRight = true;
        int leftmost = 1;
        int step = 1;
        for (int remain = n; remain > 1; remain >>= 1) {
            if (leftToRight || remain % 2 == 1)
                leftmost += step;
            step <<= 1;
            leftToRight = !leftToRight;
        }
        return leftmost;
    }
}
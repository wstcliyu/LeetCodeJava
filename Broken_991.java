class Broken_991 {
	// https://leetcode.com/problems/broken-calculator/discuss/234484/JavaC%2B%2BPython-Change-Y-to-X-in-1-Line
    public int brokenCalc(int X, int Y) {
        if (X >= Y) return X - Y;
        if (Y % 2 == 0) return 1 + brokenCalc(X, Y / 2);
        return 2 + brokenCalc(X, (Y + 1) / 2);
    }
}
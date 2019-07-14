class Confusing_1056 {
    // rotate an integer 180 degree
    public boolean confusingNumber(int N) {
        List<Integer> digits = new ArrayList<>();
        while (N > 0) {
            int d = N % 10;
            if (d >= 2 && d <= 7 && d != 6) return false;
            digits.add(d);
            N /= 10;
        }
        
        int len = digits.size();
        for (int i = 0; i < len; i++) {
            int d1 = digits.get(i);
            int d2 = digits.get(len - 1- i);
            if ((d1 == 0 && d2 != 0) || (d1 == 1 && d2 != 1) || (d1 == 6 && d2 != 9) || (d1 == 8 && d2 != 8) || (d1 == 9 && d2 != 6))
                return true;
        }
        
        return false;
    }
}
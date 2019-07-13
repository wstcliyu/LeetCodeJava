class Sum_1085 {
    public int sumOfDigits(int[] A) {
        int min = A[0];
        for (int a : A) {
            min = Math.min(a, min);
        }
        
        int sum = 0;
        while (min > 0) {
            sum += min % 10;
            min /= 10;
        }
        
        return sum % 2 == 1 ? 0 : 1;
    }
}
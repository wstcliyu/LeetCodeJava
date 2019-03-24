class Partition_1020 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) sum += a;
        if (sum % 3 != 0) return false;
        int target = sum / 3;
        
        int i = 0;
        sum = A[0];
        while (sum != target && i < A.length - 1) {
            sum += A[++i];
        }
        
        int j = A.length - 1;
        sum = A[j];
        while (sum != target && j > 0) {
            sum += A[--j];
        }
        
        return i + 1 < j;
    }
}
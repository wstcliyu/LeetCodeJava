import java.util.List;
import java.util.ArrayList;

class Permutation_60 {
    // Most voted solution
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) 
            numbers.add(i);
        
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++)
            factorial[i] = factorial[i - 1] * i;
        
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = 1; i <= n; i++) {
            int idx = k / factorial[n - i];
            k %= factorial[n - i];
            sb.append(numbers.get(idx));
            numbers.remove(idx);
        }
        
        return sb.toString();
    }
}
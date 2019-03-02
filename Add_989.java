import java.util.LinkedList;
import java.util.List;

public class Add_989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int carry = 0;
        List<Integer> res = new LinkedList<>();
        int i = A.length-1;
        while (i >= 0 || K > 0 || carry > 0) {
            int a = i >= 0 ? A[i] : 0;
            int b = K % 10;
            res.add(0, (carry + a + b) % 10);
            i--;
            K /= 10;
            carry = (carry + a + b) / 10;
        }
        return res;
    }
}

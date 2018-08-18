import java.util.ArrayList;
import java.util.List;

public class Gray_89 {
    // Most voted solution (I don't understand)
    // G(i) = i^ (i/2)
    /*
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1<<n; i++)
            result.add(i ^ i>>1);
        return result;
    }
    */

    // Second voted solution
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i=0; i<n; i++) {
            int size = res.size();
            for (int k=size-1; k>=0; k--)
                res.add(res.get(k) | (1 << i));
        }
        return res;
    }
}

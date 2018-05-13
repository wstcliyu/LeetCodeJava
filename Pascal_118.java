import java.util.ArrayList;
import java.util.List;

public class Pascal_118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i=0; i<numRows; i++) {
            List<Integer> rowResult = new ArrayList<Integer>();
            rowResult.add(1);
            for (int j=i-1; j>=1; j--) {
                rowResult.add( 0, result.get(i-1).get(j) + result.get(i-1).get(j-1) );
            }
            if (i > 0)
                rowResult.add(0,1);
            result.add(rowResult);
        }
        return result;
    }
    public static void main (String args[]) {
        int testNumRows = 5;
        List<List<Integer>> testList = generate(testNumRows);
        // Use of foreach
        for (List<Integer> i : testList)
<<<<<<< HEAD
            System.out.println(i);
=======
        System.out.println(i);
>>>>>>> e93ad0b6920f48e77ca63f5ee0126966304f7443
    }
}

import java.util.ArrayList;
import java.util.List;

public class Pascal_119 {
     public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }
        result = getRow(rowIndex-1);
        result.add(1);
        if (rowIndex>1) {
            int temp = result.get(rowIndex - 1);
            for (int i = rowIndex - 1; i > 0; i--) {
                result.remove(i);
                result.add(i, temp + result.get(i - 1));
                temp = result.get(i - 1);
            }
        }
        return result;
    }
    public static void main (String args[]) {
        int testNumRows = 4;
        List<Integer> testList = getRow(testNumRows);
        System.out.println(testList);
    }
}

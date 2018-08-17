import java.util.ArrayList;
import java.util.List;

public class Zigzag_6 {
    // My solution
    // Similar with Standard Solution Approach #2
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0)
            return "";
        if (numRows == 1) // Corner case
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numRows; i++) {
            int cur = i, sign = 1;
            while (cur < s.length()) {
                sb.append(s.charAt(cur));
                cur += (i == 0 || sign == 1 && i != numRows - 1) ? 2 * (numRows - 1 - i) : 2 * i;
                sign = 1 - sign;
            }
        }
        return sb.toString();
    }


    // Standard Solution Approach #1
    /*
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
    */
}

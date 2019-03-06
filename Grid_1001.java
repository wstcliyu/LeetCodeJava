import java.util.HashMap;
import java.awt.Point;
import java.util.HashSet;

public class Grid_1001 {
    HashMap<Integer, Integer> row = new HashMap<>();
    HashMap<Integer, Integer> col = new HashMap<>();
    HashMap<Integer, Integer> diagonal = new HashMap<>();
    HashMap<Integer, Integer> revDiag = new HashMap<>();
    HashSet<Point> set = new HashSet<>();

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        for (int[] lamp : lamps) {
            row.put(lamp[0], 1 + row.getOrDefault(lamp[0], 0));
            col.put(lamp[1], 1 + col.getOrDefault(lamp[1], 0));
            diagonal.put(lamp[0] + lamp[1], 1 + diagonal.getOrDefault(lamp[0] + lamp[1], 0));
            revDiag.put(lamp[0] - lamp[1], 1 + revDiag.getOrDefault(lamp[0] - lamp[1], 0));
            set.add(new Point(lamp[0], lamp[1]));
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0];
            int c = queries[i][1];
            res[i] = (row.containsKey(r) || col.containsKey(c) || diagonal.containsKey(r + c) || revDiag.containsKey(r - c)) ? 1 : 0;
            turnOffLamp(r, c);
        }
        return res;
    }

    private void turnOffLamp(int r, int c) {
        for (int x = r-1; x <= r+1; x++) {
            for (int y = c-1; y <= c+1; y++) {
                if (set.remove(new Point(x, y))) {
                    row.put(x, row.get(x) - 1);
                    row.remove(x, 0);
                    col.put(y, col.get(y) - 1);
                    col.remove(y, 0);
                    diagonal.put(x+y, diagonal.get(x+y) - 1);
                    diagonal.remove(x+y, 0);
                    revDiag.put(x-y, revDiag.get(x-y) - 1);
                    revDiag.remove(x-y, 0);
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {1, 2};
        System.out.println(A);
        System.out.println(A.hashCode());
        System.out.println(B.hashCode());
        HashMap<int[], Integer> map = new HashMap<>();
        map.put(A, 5);
        System.out.println(map.containsKey(B));


        Point C = new Point(1, 2);
        Point D = new Point(1, 2);
        System.out.println(C.hashCode());
        System.out.println(D.hashCode());

        Grid_1001 test = new Grid_1001();
        int N = 5;
        int[][] lamps = {{0, 0}, {4, 4}};
        int[][] queries = {{1, 1}, {1, 0}};
        int[] res = test.gridIllumination(N, lamps, queries);
    }
}

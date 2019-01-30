import java.util.*;

public class MinimizeCost {
    // Amazon OA 2: MST

    public class Connections {
        public String first, second;
        public int cost;
        Connections() {}
        Connections(String t1, String t2, int c) {
            first = t1;
            second = t2;
            cost = c;
        }
    }

    HashMap<String, String> map;

    public List<Connections> minimizeCostConnection(List<Connections> connection) {
        List<Connections> res = new LinkedList<>();
        connection.sort(Comparator.comparing((Connections con) -> con.cost));
        map = new HashMap<>();
        for (Connections con : connection) {
            String a = find(con.first);
            String b = find(con.second);
            if (!a.equals(b)) {
                res.add(con);
                map.put(a, b);
            }
        }
        String root = map.get(res.get(0).first);
        for (Connections con : res) {
            String a = map.get(con.first);
            String b = map.get(con.second);
            if (!root.equals(a) || !root.equals(b)) return new ArrayList<>();
        }
        return res;
    }

    private String find(String v) {
        map.putIfAbsent(v, v);
        String parent = map.get(v);
        if (v.equals(parent)) return v;
        map.put(v, find(parent));
        return map.get(v);
    }

    /*
    private void union(String v, String w) {
        String a = find(v);
        String b = find(w);
        map.put(a, b);
    }

    private boolean connected(String v, String w) {
        String a = find(v);
        String b = find(w);
        return a.equals(b);
    }
    */

    public static void main(String[] args) {
        MinimizeCost test = new MinimizeCost();
        List<Connections> con = new LinkedList<>();
        con.add(test.new Connections("A", "B", 1));
        con.add(test.new Connections("C", "B", 4));
        con.add(test.new Connections("A", "C", 5));
        con.add(test.new Connections("C", "D", 3));
        con.add(test.new Connections("E", "F", 8));
        List<Connections> ls = test.minimizeCostConnection(con);
        for (Connections c : ls)
            System.out.println(c.first + ", " + c.second + ", " + c.cost);
    }
}

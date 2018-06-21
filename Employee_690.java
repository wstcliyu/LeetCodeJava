import java.util.HashMap;
import java.util.List;

public class Employee_690 {
    class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
    }
    HashMap<Integer, Employee> map = new HashMap<>();
    /*
       Good practice for bfs and dfs
     */
    public int getImportance(List<Employee> employees, int id) {
        for (Employee i:employees)
            map.put(i.id, i);
        return dfs(map.get(id));
        // My first solution without HashMap, very slow
        /*
        int res = 0;
        for (Employee i:employees) {
            if (i.id != id)
                continue;
            res = i.importance;
            if (i.subordinates == null)
                return res;
            for (int j:i.subordinates)
                res += getImportance(employees, j);
        }
        return res;
        */
    }
    private int dfs(Employee e) {
        int res = e.importance;
        for (int s:e.subordinates)
            res += dfs(map.get(s));
        return res;
    }
}
// Most voted solution using HashMap, Queue and bfs
/*
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int total = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            Employee current = queue.poll();
            total += current.importance;
            for (int subordinate : current.subordinates) {
                queue.offer(map.get(subordinate));
            }
        }
        return total;
    }
}
*/
// Most voted solution using HashMap and dfs
/*
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return getImportanceHelper(map, id);
    }

    private int getImportanceHelper(Map<Integer, Employee> map, int rootId) {
        Employee root = map.get(rootId);
        int total = root.importance;
        for (int subordinate : root.subordinates) {
            total += getImportanceHelper(map, subordinate);
        }
        return total;
    }
}
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Find_609 {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                // Standard solution
                /*
                String[] name_cont = values[i].split("\\(");
                // Split by (
                name_cont[1] = name_cont[1].replace(")", "");
                // Remove )
                */
                int open = values[i].indexOf("(");
                int close =  values[i].indexOf(")");
                String content = values[i].substring(open + 1, close);
                String name = values[i].substring(0, open);
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(values[0] + "/" + name);
            }
        }
        // If we do not need to check map.get(key).size(), we can use
        // List<List<String>> res = new ArrayList<>(map.values();
        List<List<String>> res = new ArrayList<>();
        for (String key: map.keySet())
            if (map.get(key).size() > 1)
                res.add(map.get(key));
        return res;
    }
}

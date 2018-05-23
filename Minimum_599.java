import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length > list2.length)
            return findRestaurant(list2, list1);
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<list1.length; i++)
            map.put(list1[i], i);
        List<String> res = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for (int j=0; j<list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int sum = map.get(list2[j])+j;
                if (sum < minSum) {
                    // clear() the whole result list when finding a smaller sum
                    res.clear();
                    res.add(list2[j]);
                    minSum = sum;
                }
                else if (sum == minSum)
                    res.add(list2[j]);
            }
        }
        return res.toArray(new String[0]);
    }
}

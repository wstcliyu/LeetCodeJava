import java.util.*;

class Different_241 {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> ls1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> ls2 = diffWaysToCompute(input.substring(i + 1));
                for (int x : ls1) {
                    for (int y : ls2) {
                        switch (c) {
                            case '+': res.add(x + y); break;
                            case '-': res.add(x - y); break;
                            case '*': res.add(x * y); break;
                        }
                    }
                }
            }
        }
        
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        
        map.put(input, res);
        
        return res;
    }
}
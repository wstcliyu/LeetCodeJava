import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

class Maximum_895 {
    // Standard solution: HashMap of Stacks

    int maxFreq;
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    
    public FreqStack() {
        maxFreq = 0;
        freq = new HashMap<>();
        group = new HashMap<>();
    }
    
    public void push(int x) {
        freq.put(x, 1 + freq.getOrDefault(x, 0));
        int f = freq.get(x);
        maxFreq = Math.max(maxFreq, f);
        group.computeIfAbsent(f, z -> new Stack<>()).push(x);
    }
    
    public int pop() {
        int res = group.get(maxFreq).pop();
        freq.put(res, freq.get(res) - 1);
        if (group.get(maxFreq).empty())
            maxFreq--;
        return res;
    }
}

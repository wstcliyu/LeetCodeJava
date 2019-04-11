import java.util.Set;
import java.util.HashSet;

class Sliding_773 {
    // My solution using Bidirectional BFS
    public int slidingPuzzle(int[][] board) {
        String end = "123450";
        String begin = "";
        for (int[] row : board) for (int num : row) begin += num;
        if (begin.equals(end)) return 0;
        
        Set<String> beginSet = new HashSet<>();
        beginSet.add(begin);
        Set<String> endSet = new HashSet<>();
        endSet.add(end);
        Set<String> visited = new HashSet<>(Arrays.asList(begin, end));
        
        int step = 1;
        int[][] positions = new int[][] { { 1, 3 }, { 0, 2, 4 },
                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            
            Set<String> nextLevel = new HashSet<>();
            for (String str : beginSet) {
                int zeroIdx = str.indexOf('0');
                for (int pos : positions[zeroIdx]) {
                    String candidate = swap(str, zeroIdx, pos);
                    if (endSet.contains(candidate))
                        return step;
                    if (!visited.contains(candidate)) {
                        visited.add(candidate);
                        nextLevel.add(candidate);
                    }
                }
            }
            
            beginSet = nextLevel;
            step++;
        }
        
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
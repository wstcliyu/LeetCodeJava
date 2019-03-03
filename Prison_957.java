import java.util.HashMap;

public class Prison_957 {
	// My solution (similar with standard solution)

	public int[] prisonAfterNDays(int[] cells, int N) {
        int state = 0;
        for (int i = 0; i < cells.length; i++)
            state |= (cells[i] << i);

        HashMap<Integer, Integer> seen = new HashMap<>();
        int today = 0;
        while (today < N && !seen.containsKey(state)) {
            seen.put(state, today++);
            state = nextDay(state);
        }
        if (today == N) 
        	return stateToArray(state);
        
        int prev = seen.get(state);
        int cycle = today - prev;
        int remainder = (N - today) % cycle;
        while (remainder-- > 0) 
        	state = nextDay(state);
        return stateToArray(state);
    }
    
    private int[] stateToArray(int state) {
        int[] result = new int[8];
        for (int i = 0; i < 8; i++)
            result[i] = ((state >> i) & 1);
        return result;
    }
    
    private int nextDay(int state) {
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            if (((state >> (i-1)) & 1) == ((state >> (i+1)) & 1))
                res |= (1 << i);
        }
        return res;
    }
}
import java.util.*;

class Strobogrammatic_247 {
	// Most voted solution
	public List<String> findStrobogrammatic(int n) {
	    return helper(n, n);
	}

	List<String> helper(int n, int m) {
	    if (n == 0) return new ArrayList<String>(Arrays.asList(""));
	    if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
	    
	    List<String> list = helper(n - 2, m);
	    
	    List<String> res = new ArrayList<String>();
	    
	    for (int i = 0; i < list.size(); i++) {
	        String s = list.get(i);
	        
	        if (n != m) res.add("0" + s + "0");
	        
	        res.add("1" + s + "1");
	        res.add("6" + s + "9");
	        res.add("8" + s + "8");
	        res.add("9" + s + "6");
	    }
	    
	    return res;
	}



	// My updated solution using BFS
	/*
	public List<String> findStrobogrammatic(int n) {
        LinkedList<String> q = new LinkedList<>();
        if (n % 2 == 0) {
            q.add("");
        } else {
            q.addAll(Arrays.asList("0", "1", "8"));
        }
        
        for (int i = 0; i < n/2; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String s = q.removeFirst();
                if (i < n/2 - 1) q.add("0" + s + "0");
                q.add("1" + s + "1");
                q.add("8" + s + "8");
                q.add("6" + s + "9");
                q.add("9" + s + "6");
            }
        }
        
        return q;
    }
    */
}
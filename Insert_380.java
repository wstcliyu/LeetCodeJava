import java.util.*;

public class Insert_380 {
	ArrayList<Integer> nums;
    HashMap<Integer, Integer> locations;
    Random rand;
    

    /** Initialize your data structure here. */
    public Insert_380() {
        nums = new ArrayList<>();
        locations = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locations.containsKey(val)) return false;
        locations.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locations.containsKey(val)) return false;
        int lastNum = nums.get(nums.size()-1);
        if (val != lastNum) {
            int loc = locations.get(val);
            nums.set(loc, lastNum);
            locations.put(lastNum, loc);
        }
        locations.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
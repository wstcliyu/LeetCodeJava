import java.util.*;

public class Insert_381 {
	ArrayList<Integer> nums;
    HashMap<Integer, HashSet<Integer>> locations;
    Random rand;
    

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        locations = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean canInsert = !locations.containsKey(val);
        locations.putIfAbsent(val, new HashSet<>());
        locations.get(val).add(nums.size());
        nums.add(val);
        return canInsert;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!locations.containsKey(val)) return false;
        int lastNum = nums.get(nums.size()-1);
        HashSet<Integer> locOfLast = locations.get(lastNum);
        if (val != lastNum) {
            int loc = locations.get(val).iterator().next();  
            locations.get(val).remove(loc);
            locOfLast.add(loc);
            nums.set(loc, lastNum);
        }
        locOfLast.remove(nums.size()-1);
        nums.remove(nums.size()-1);
        
        if (locations.get(val).isEmpty())
            locations.remove(val);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
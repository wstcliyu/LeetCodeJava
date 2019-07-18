import java.util.*;

class Logger_359 {
    
    Map<String, Integer> registry;

    /** Initialize your data structure here. */
    public Logger_359() {
        registry = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!registry.containsKey(message) || timestamp - registry.get(message) >= 10) {
            registry.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }



    // Most voted solution
    /*
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < ok.getOrDefault(message, 0))
            return false;
        ok.put(message, timestamp + 10);
        return true;
    }
    */
}
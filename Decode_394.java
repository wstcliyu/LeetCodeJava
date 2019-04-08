import javafx.util.Pair;
import java.util.Deque;
import java.util.ArrayDeque;

class Decode_394 {
    // Rewrite most voted solution
    public String decodeString(String s) {
        StringBuilder cur = new StringBuilder();
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> prefixStack = new ArrayDeque<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                countStack.addLast(count);
                count = 0;
                prefixStack.addLast(cur);
                cur = new StringBuilder();
            } else if (c == ']') {
                int repeatTime = countStack.removeLast();
                StringBuilder prefix = prefixStack.removeLast();
                for (int i = 0; i < repeatTime; i++)
                    prefix.append(cur);
                cur = prefix;
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }




    // My first solution
    /*
    public String decodeString(String s) {
        Deque<Pair<Integer, StringBuilder>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(1, new StringBuilder()));
        int repeat = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                repeat = repeat * 10 + c - '0';
            } else if (c == '[') {
                deque.addLast(new Pair<>(repeat, new StringBuilder()));
                repeat = 0;
            } else if (c == ']') {
                Pair<Integer, StringBuilder> pair = deque.removeLast();
                StringBuilder sb = helper(pair.getKey(), pair.getValue());
                deque.getLast().getValue().append(sb);
            } else {
                deque.getLast().getValue().append(c);
            }
        }
        return deque.getLast().getValue().toString();
    }
    
    private StringBuilder helper(int repeat, StringBuilder sb) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < repeat; i++) res.append(sb);
        return res;
    }
    */
}
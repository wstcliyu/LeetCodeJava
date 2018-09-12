import java.util.ArrayList;
import java.util.HashSet;

public class Buddy_859 {
    // The thought in these three solutions are the same

    // Most voted solution
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            HashSet<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size() < A.length();
        }
        ArrayList<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) if (A.charAt(i) != B.charAt(i)) dif.add(i);
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }

    // My first solution
    /*
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        ArrayList<Integer> dif = new ArrayList<>();
        boolean hasRepeat = false;
        boolean[] seen = new boolean[26];
        for (int i = 0; i < A.length(); i++) {
            if (!hasRepeat && seen[A.charAt(i) - 'a'])
                hasRepeat = true;
            seen[A.charAt(i) - 'a'] = true;
            if (A.charAt(i) != B.charAt(i))
                dif.add(i);
            if (dif.size() > 2)
                return false;
        }
        if (dif.size() == 0 && hasRepeat)
            return true;
        if (dif.size() == 2) {
            int first = dif.get(0), second = dif.get(1);
            if (A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first))
                return true;
        }
        return false;
    }
    */

    // Standard Solution
    /*
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));
        }
    }
    */
}

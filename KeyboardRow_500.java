import java.util.*;
import java.util.stream.Stream;

public class KeyboardRow_500 {
    public static String[] findWords(String[] words) {
        /* Most voted solution using Stream
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
                .toArray(String[]::new);
        */

        /* My first solution
        List<String> res = new ArrayList<>();
        Set<Character> first = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set<Character> second = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        Set<Character> third = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
        for (String word:words) {
            boolean a = true, b = true, c = true;
            for (char ch:word.toLowerCase().toCharArray()) {
                if (!first.contains(ch))
                    a = false;
                if (!second.contains(ch))
                    b = false;
                if (!third.contains(ch))
                    c = false;
            }
            if (a||b||c)
                res.add(word);
        }
        String[] final_res = new String[res.size()];
        int i = 0;
        for (String result:res)
            final_res[i++] = result;
        return final_res;
        */

        List<String> res = new ArrayList<>();
        for (String word:words) {
            int row = getRowNumber(word.toLowerCase().charAt(0));
            boolean isResult = true;
            for (char ch:word.toLowerCase().toCharArray()) {
                if (getRowNumber(ch) != row)
                    isResult = false;
            }
            if (isResult)
                res.add(word);
        }
        // If you write only res.Array(), you will get an array of Object, not String
        return res.toArray(new String[0]);
    }
    private static int getRowNumber(char ch) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i=0; i<rows.length; i++) {
            if (rows[i].indexOf(ch) >= 0)
                return i;
        }
        return -1;
    }

    public static void main (String args[]) {
        String[] testWords = {"Hello", "Alaska", "Dad", "Peace"};
        for (String s:findWords(testWords))
            System.out.println(s);
    }
}

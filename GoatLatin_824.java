import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class GoatLatin_824 {
    public static String toGoatLatin(String S) {
        StringBuilder goatLatin = new StringBuilder();
        String[] result = S.split(" ");
        Character[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        // Or use List<Character> vowelsList = new ArrayList<>(Arrays.asList(vowels));
        Set<Character> vowelsList = new HashSet<>(Arrays.asList(vowels));
        for (int i=0; i<result.length; i++) {
            char c = result[i].charAt(0);
            StringBuilder goatWord = new StringBuilder(result[i]);
            if (!vowelsList.contains(c))
                goatWord.deleteCharAt(0).append(c);
            goatWord.append("ma");
            for (int j=0; j<i+1; j++)
                goatWord.append("a");
            goatLatin.append(" "+goatWord);
        }
        return goatLatin.deleteCharAt(0).toString();
    }
    public static void main(String[] args) {
        String testS = "I speak Goat Latin";
        System.out.println(toGoatLatin(testS));
    }
}

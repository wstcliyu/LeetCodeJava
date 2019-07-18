import java.util.List;
import java.util.ArrayList;

class Occurrences_1078 {
    // My first solution
    /*
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                res.add(words[i + 2]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
    */



    // From scratch
    // Good practice for text search
    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        
        String prefix = first + " " + second + " ";
        int len = prefix.length();
        int N = text.length();
        int i = 0;
        
        while (i >= 0 && i < N) {
            int idx = text.indexOf(prefix, i);
            if (idx < 0) break;
            
            int start = idx + len;
            if (start >= N) break;
            
            int end = text.indexOf(" ", idx + len);
            if (end < 0) end = N;
            
            res.add(text.substring(start, end));
            i = idx + first.length() + 1;
        }
        
        return res.toArray(new String[res.size()]);
    }
}
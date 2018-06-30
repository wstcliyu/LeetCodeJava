import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;

public class Substring_30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        LinkedList<Integer> res = new LinkedList<>();
        if (s==null || s.length()==0 || words==null || words.length==0)
            return res;
        HashMap<String, Integer> freq = new HashMap<>(), curMap = new HashMap<>();
        for (String w:words)
            freq.put(w, 1+freq.getOrDefault(w,0));
        int wl = words[0].length();
        for (int i=0; i<wl; i++) {
            int start = i, count = 0;
            for (int end=i; end+wl<=s.length(); end+=wl) {
                String curStr = s.substring(end, end+wl);
                if (!freq.containsKey(curStr)) {
                    curMap.clear();
                    count = 0;
                    start = end + wl;
                }
                else {
                    curMap.put(curStr, 1+curMap.getOrDefault(curStr,0));
                    if (curMap.get(curStr) <= freq.get(curStr))
                        count++;
                    while (count == words.length || curMap.get(curStr) > freq.get(curStr)) {
                        if (count == words.length)
                            res.add(start);
                        String tmpStr = s.substring(start, start+wl);
                        start += wl;
                        curMap.put(tmpStr, -1+curMap.get(tmpStr));
                        if (curMap.get(tmpStr) < freq.get(tmpStr))
                            count--;
                    }
                }
            }
            curMap.clear();
        }
        return res;
    }
    public static void main(String[] args) {
        String testS = "barfoofoobarthefoobarman";
        String[] testWords = {"bar","foo","the"};
        System.out.println(Arrays.toString(findSubstring(testS,testWords).toArray()));
    }
}

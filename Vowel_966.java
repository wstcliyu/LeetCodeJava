import java.util.HashMap;
import java.util.HashSet;

public class Vowel_966 {
	// Standard solution using Hash Table
	HashSet<String> word_perfect = new HashSet<>();
	HashMap<String, String> word_cap = new HashMap<>();
	HashMap<String, String> word_vow = new HashMap<>();

	public String[] spellchecker(String[] wordlist, String[] queries) {
		init(wordlist);
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) res[i] = solve(queries[i]);
        return res;
    }

    private String solve(String q) {
    	if (word_perfect.contains(q)) return q;

    	String qLow = q.toLowerCase();
    	if (word_cap.containsKey(qLow)) return word_cap.get(qLow);

    	String qLowDV = devowel(qLow);
    	if (word_vow.containsKey(qLowDV)) return word_vow.get(qLowDV);

    	return "";
    }

    private void init(String[] wordlist) {
    	for (String w : wordlist) {
    		word_perfect.add(w);

    		String wLow = w.toLowerCase();
    		word_cap.putIfAbsent(wLow, w);

    		String wLowDV = devowel(wLow);
    		word_vow.putIfAbsent(wLowDV, w);
    	}
    }

    private String devowel(String w) {
    	String vowels = "aeiou";
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < w.length(); i++) {
    		char c = w.charAt(i);
    		sb.append(vowels.indexOf(c) >= 0 ? "#" : c);
    	}
    	return sb.toString();
    }




	// My first solution
	// Brute Force (very slow)
	/*
	public String[] spellchecker(String[] wordlist, String[] queries) {
        int N = queries.length;
        String[] res = new String[N];
        for (int i = 0; i < N; i++)
            res[i] = getAnswer(wordlist, queries[i]);
        return res;
    }
    
    private String getAnswer(String[] wordlist, String query) {
        String capMatch = "";
        String vowMatch = "";
        for (String word : wordlist) {
            if (word.equals(query)) return word;
            String lowCaseW = word.toLowerCase();
            String lowCaseQ = query.toLowerCase();
            if (capMatch.isEmpty() && lowCaseW.equals(lowCaseQ))
                capMatch = word;
            if (vowMatch.isEmpty() && vowelErr(lowCaseW, lowCaseQ))
                vowMatch = word;
        }
        return capMatch.isEmpty() ? (vowMatch.isEmpty() ? "" : vowMatch) : capMatch;
    }
    
    private boolean vowelErr(String w, String q) {
        String vowel = "aeiou";
        if (w.length() != q.length()) return false;
        for (int i = 0; i < w.length(); i++) {
            char c1 = w.charAt(i);
            char c2 = q.charAt(i);
            if (vowel.indexOf(c1) >= 0 && vowel.indexOf(c2) >= 0) continue;
            if (c1 != c2) return false;
        }
        return true;
    }
    */
}
import java.util.HashSet;

public class Unique_929 {
	public int numUniqueEmails(String[] emails) {
		HashSet<String> set = new HashSet<>();
		for (String email : emails) {
			String[] name = email.split("@");
			int idx = name[0].indexOf("+");
			if (idx >= 0) 
				name[0] = name[0].substring(0, idx);
			// replace(".", "")
            // Not replace("\\.", "") or replace('.', '')
			set.add(name[0].replace(".", "") + "@" + name[1]);
		}
		return set.size();
    }

    public static void main(String[] args) {
    	String test = "leetcode.com";
    	System.out.println(test.replace(".", ""));
    }
}
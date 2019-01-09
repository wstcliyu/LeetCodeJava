import java.util.*;

public class Subdomain_811 {
    public static List<String> subdomainVisits(String[] cpdomains) {
        // The regX of one or more space is \\s+
        // The regX of . is \\.
        Map<String, Integer> counts = new HashMap();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (Map.Entry<String, Integer> entry : counts.entrySet())
            ans.add(entry.getValue() + " " + entry.getKey());
        return ans;
    }
    public static void main (String args[]) {
        String[] testCpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        for (String s:subdomainVisits(testCpdomains))
            System.out.println(s);
    }
}

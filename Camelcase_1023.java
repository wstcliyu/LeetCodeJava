class Camelcase_1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries)
            res.add(isSubsequence(query, pattern));
        return res;
    }
    
    private boolean isSubsequence(String query, String pattern) {
        int i = 0, j = 0;

        // Rewrite my version using most voted solution
        for (i = 0; i < query.length(); i++) {
            if (j < pattern.length() && query.charAt(i) == pattern.charAt(j))
                j++;
            else if (Character.isUpperCase(query.charAt(i)))
                return false;
        }

        return j == pattern.length();
        

        // My version
        /*
        while (i < query.length() && j < pattern.length()) {
            if (query.charAt(i) == pattern.charAt(j)) {
                i++; j++;
            } else if (Character.isUpperCase(query.charAt(i)))
                return false;
            else
                i++;
        }

        if (j < pattern.length()) return false;
        while (i < query.length())
            if (Character.isUpperCase(query.charAt(i++))) return false;
        
        return true;
        */
    }
}
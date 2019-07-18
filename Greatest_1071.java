class Greatest_1071 {
    // My first solution
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() > str2.length()) return gcdOfStrings(str2, str1);
        for (int i = 1; i <= str1.length(); i++) {
            if (str1.length() % i == 0) {
                int resLen = str1.length() / i;
                String candidate = str1.substring(0, resLen);
                
                StringBuilder sb = new StringBuilder();                
                int rep1 = i;
                for (int j = 0; j < rep1; j++) sb.append(candidate);
                if (!sb.toString().equals(str1)) continue;
                
                sb = new StringBuilder();
                int rep2 = str2.length() / resLen;
                for (int j = 0; j < rep2; j++) sb.append(candidate);
                if (sb.toString().equals(str2)) 
                    return candidate;
            }
        }
        return "";
    }



    // Most voted solution: similar to gcd of two integers
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() > str2.length()) 
            return gcdOfStrings(str2, str1);
        else if (!str2.startsWith(str1))
            return "";
        else if (str1.isEmpty())
            return str2;
        else
            return gcdOfStrings(str1, str2.substring(str1.length()));
    }
}
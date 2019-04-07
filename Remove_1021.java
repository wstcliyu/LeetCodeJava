class Remove_1021 {
    // Most voted solution
    public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }



    
    // My first solution
    /*
    public String removeOuterParentheses(String S) {
        List<String> ls = new ArrayList<>();
        int start = 0, sum = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                sum++;
            else if (S.charAt(i) == ')')
                sum--;
            
            if (sum == 0) {
                ls.add(S.substring(start + 1, i));
                start = i + 1;
            }
        }
        String res = "";
        for (String str : ls)
            res += str;
        return res;
    }
    */
}
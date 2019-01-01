public class Push_838 {
    // My solution (I improved it using some tricks in most voted solution)
    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder("L" + dominoes + "R");
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '.') {
                int start = i;
                while(sb.charAt(i) == '.')
                    i++;
                helper(sb, start, i);
            }
        }
        return sb.substring(1, sb.length() - 1);
    }
    private void helper(StringBuilder sb, int start, int end) {
        if (sb.charAt(start - 1) == 'R' && sb.charAt(end) == 'L') {
            for (int i = 0; i < (end - start) / 2; i++) {
                sb.setCharAt(start + i, 'R');
                sb.setCharAt(end - 1 - i, 'L');
            }
        }
        else if (sb.charAt(start - 1) == sb.charAt(end)) {
            for (int i = 0; i < end - start; i++)
                sb.setCharAt(start + i, sb.charAt(end));
        }
    }
}

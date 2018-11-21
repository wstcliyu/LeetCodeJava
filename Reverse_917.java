public class Reverse_917 {
    public String reverseOnlyLetters(String S) {
        int left = 0, right = S.length() - 1;
        StringBuilder sb = new StringBuilder(S);
        while (left < right) {
            while (left < S.length() && !Character.isLetter(S.charAt(left)))
                left++;
            while (right >= 0 && !Character.isLetter(S.charAt(right)))
                right--;
            if (left < right) {
                sb.setCharAt(right, S.charAt(left));
                sb.setCharAt(left, S.charAt(right));
                left++;
                right--;
            }
        }
        return sb.toString();
    }
}

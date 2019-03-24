class Shifting_848 {
    // My solution (similar with standard solution)
    public String shiftingLetters(String S, int[] shifts) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum = (sum + shifts[i]) % 26;
            int d = (S.charAt(i) - 'a' + sum) % 26;
            sb.append((char)(d + 'a'));
        }
        
        return sb.reverse().toString();
    }
}
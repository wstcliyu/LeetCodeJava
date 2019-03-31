class Convert_1017 {
    public String baseNeg2(int N) {
        if (N == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            int digit = Math.abs(N % (-2));
            sb.append(digit);
            N = (N - digit) / (-2);
        }
        return sb.reverse().toString();
    }
}
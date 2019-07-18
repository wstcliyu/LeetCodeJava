class Similar_800 {
    // Good practice for converting base of integers
    public String similarRGB(String color) {
        int[] res = {getMostSimilar(Integer.parseInt(color.substring(1, 3), 16)), 
                     getMostSimilar(Integer.parseInt(color.substring(3, 5), 16)), 
                     getMostSimilar(Integer.parseInt(color.substring(5, 7), 16))};
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < 3; i++) {
            int num = res[i] % 16;
            char c = num < 10 ? (char)('0' + num) : (char)('a' + num - 10);
            sb.append(c).append(c);
        }
        return sb.toString();
    }
    
    private int getMostSimilar(int x) {
        int distance = 256;
        int res = 0;
        for (int a = 0; a < 256; a += 17) {
            int tmp = (a - x) * (a - x);
            if (tmp < distance) {
                distance = tmp;
                res = a;
            }
        }
        return res;
    }
}
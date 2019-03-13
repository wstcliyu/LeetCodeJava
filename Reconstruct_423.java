class Reconstruct_423 {
    public String originalDigits(String s) {
        int[] count = new int[10];
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'z': count[0]++; break;
                case 'w': count[2]++; break;
                case 'u': count[4]++; break;
                case 'x': count[6]++; break;
                case 'g': count[8]++; break;
                case 'f': count[5]++; break; // f = 5 + 4
                case 's': count[7]++; break; // s = 7 + 6
                case 'h': count[3]++; break; // h = 3 + 8
                case 'i': count[9]++; break; // i = 9 + 5 + 6 + 8
                case 'o': count[1]++; break; // o = 1 + 0 + 2 + 4
            }
        }
        count[5] -= count[4];
        count[7] -= count[6];
        count[3] -= count[8];
        count[9] = count[9] - count[5] - count[6] - count[8];
        count[1] = count[1] - count[0] - count[2] - count[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++){
            for (int j = 0; j < count[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
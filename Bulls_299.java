public class Bulls_299 {
    public String getHint(String secret, String guess) {
        int bulls = 0, sum = 0;
        int[] freq = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            freq[secret.charAt(i) - '0']++;
            if (secret.charAt(i) == guess.charAt(i))
                bulls++;
        }
        for (char c : guess.toCharArray()) {
            if (freq[c - '0']-- > 0)
                sum++;
        }
        return bulls + "A" + (sum - bulls) + "B";
    }
}

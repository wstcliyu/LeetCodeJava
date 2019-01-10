public class Shortest_748 {

    // https://leetcode.com/problems/shortest-completing-word/discuss/158110/Java-6ms-beats-100-PRIME-NUMBERS
    // Idea: assign each letter a prime number and compute the product for the license plate.
    // Then, compute the product for each word in wordlist.
    // If the char product for a word is divisible by the license plate char product, it contains all the characters.

    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
            37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

    public String shortestCompletingWord(String licensePlate, String[] words) {
        long charProduct = getCharProduct(licensePlate.toLowerCase());
        String shortest = "1234567890abcdef";
        for (String word : words) {
            if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                shortest = word;
        }
        return shortest;
    }

    private long getCharProduct(String plate) {
        long product = 1L;
        for (char c : plate.toCharArray()) {
            int index = c - 'a';
            if (index >= 0 && index < 26)
                product *= primes[index];
        }
        return product;
    }

    // My solution
    /*
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] freq = getFreq(licensePlate.toLowerCase());
        String shortest = "1234567890abcdef";
        for (String word : words) 
            if (word.length() < shortest.length() && compareArray(freq, getFreq(word))) shortest = word;
        return shortest;
    }
    
    private int[] getFreq(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) 
            if (c - 'a' >= 0 && c - 'a' < 26) freq[c - 'a']++;
        return freq;
    }
    
    private boolean compareArray(int[] freq, int[] f) {
        for (int i = 0; i < f.length; i++) 
            if (freq[i] > f[i]) return false;
        return true;
    }
    */
}

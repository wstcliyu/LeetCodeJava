public class Find_744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if (letters[n-1] <= target)
            return letters[0];
        int left = 0;
        int right = n-1;
        while (left < right) {
            int mid = (left+right)/2+1;
            if (letters[mid] <= target)
                left = mid + 1;
            else if (letters[mid-1] <= target)
                return letters[mid];
            else
                right = mid - 1;
        }
        return letters[left];
    }
    public static void main (String args[]) {
        char[] testLetters = {'f','f','f'};
        char testTarget = 'c';
        System.out.println(nextGreatestLetter(testLetters, testTarget));
    }
}

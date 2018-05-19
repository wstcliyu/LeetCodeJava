public class ReverseWords_557 {
    public static String reverseWords(String s) {
        StringBuilder revWords = new StringBuilder();
        String[] result = s.split(" ");
        for (String word:result)
            revWords.append(new StringBuilder(word).reverse()+" ");
        revWords.deleteCharAt(revWords.length()-1);
        return revWords.toString();
    }
    public static void main(String[] args) {
        String testS = "s'teL ekat edoCteeL tsetnoc";
        System.out.println(reverseWords(testS));
    }
}

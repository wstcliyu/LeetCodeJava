public class KthSymbol_779 {
    public static int kthGrammar(int N, int K) {
        if (N==1 && K==1)
            return 0;
        return K%2==1 ? kthGrammar(N-1,(K+1)/2) : 1-kthGrammar(N-1,(K+1)/2);
    }
    public static void main (String args[]) {
        int testN = 4;
        int testK = 5;
        System.out.println(kthGrammar(testN,testK));
    }
}

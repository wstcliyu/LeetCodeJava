public class NthDigit_400 {
    public static int findNthDigit(int n) {
        int i;
        for (i=1;i<=8;i++){
            if(n >= i*9*Math.pow(10,i-1))
                n = n - (int)(i*9*Math.pow(10,i-1));
            else break;
        }
        if (n == 0) return 9;
        int num = (n-1)/i + (int)(Math.pow(10,i-1));
        int k = (n-1)%i + 1;
        int j = 0;
        while (j<i-k) {
            num = num/10;
            j++;
        }
        return num%10;
    }

    public static void main (String args[]) {
        System.out.println(findNthDigit(9));
    }
}
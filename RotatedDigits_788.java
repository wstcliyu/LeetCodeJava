public class RotatedDigits_788 {
    public static int rotatedDigits(int N) {
        int count = 0;
        for (int num=1; num<=N; num++) {
            int temp = num;
            boolean good = false;
            while(temp > 0) {
                int d = temp%10;
                if (d==3 || d==4 || d==7)
                    break;
                if ((d==2 || d==5 || d==6 || d==9) && !good)
                    good = true;
                temp /= 10;
            }
            if (temp==0 && good)
                count++;
        }
        return count;
    }
    public static void main (String args[]) {
        int testN = 10;
        System.out.println(rotatedDigits(testN));
    }
}

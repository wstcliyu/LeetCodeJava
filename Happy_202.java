import java.util.HashSet;

public class Happy_202 {
    public static boolean isHappy(int n) {
    // Use HashSet
        HashSet<Integer> set = new HashSet<Integer>();
        while(!set.contains(n)){
            set.add(n);
            n = getSum(n);
            if(n==1)
                return true;
        }
        return false;


        /* Floyd Cycle Detection Algorithm
        int slow, fast;
        slow = fast = n;
        do {
            slow = getSum(slow);
            fast = getSum(fast);
            fast = getSum(fast);
        } while(slow != fast);
        return (slow == 1);
        */
    }
    public static int getSum(int n) {
        int sum = 0;
        while (n>0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}

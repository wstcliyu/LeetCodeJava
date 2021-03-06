public class Lemonade_860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0)
            return true;
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5)
                five++;
            if (bill == 10) {
                if (five == 0)
                    return false;
                five--;
                ten++;
            }
            if (bill == 20) {
                if (ten == 0)
                    five -= 3;
                else {
                    ten--;
                    five--;
                }
                if (ten < 0 || five < 0)
                    return false;
            }
        }
        return true;
    }
}

import java.util.HashMap;

public class Fraction_166 {
    // Must convert to long integer because the denominator can be Integer.MIN_VALUE
    public String fractionToDecimal(int numerator, int denominator) {
        int sign = Integer.signum(numerator) * Integer.signum(denominator);
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        StringBuilder sb = new StringBuilder();
        if (sign < 0) sb.append("-");
        sb.append(num / den);
        num %= den;
        if (num == 0) return sb.toString();
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while (num != 0 && !map.containsKey(num)) {
            map.put(num, sb.length());
            num *= 10;
            sb.append(num / den);
            num %= den;
        }
        if (num != 0) {
            int prev = map.get(num);
            sb.insert(prev, "(").append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Fraction_166 test = new Fraction_166();
        System.out.println(test.fractionToDecimal(1, Integer.MIN_VALUE));
    }
}

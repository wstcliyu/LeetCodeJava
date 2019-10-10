class Fraction_592 {
    // My first solution
    /*
    public String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;
        int sign = 1;
        boolean numeratorTaken = false;
        int x = 0, y = 0;
        for (int i = 0; i <= expression.length(); i++) {
            if (i == expression.length() || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                if (y > 0) {
                    numerator = numerator * y + sign * x * denominator;
                    denominator *= y;
                    int g = gcd(Math.abs(numerator), denominator);
                    numerator /= g;
                    denominator /= g;
                }
                
                numeratorTaken = false;
                x = 0;
                y = 0;
                if (i < expression.length()) {
                    if (expression.charAt(i) == '+') sign = 1;
                    else sign = -1;
                }
                
                continue;
            }
            
            char c = expression.charAt(i);
            
            if (c == '/') numeratorTaken = true;
            
            if (Character.isDigit(c)) {
                if (!numeratorTaken) {
                    x = x * 10 + c - '0';
                } else {
                    y = y * 10 + c - '0';
                }
            }
        }
        return String.valueOf(numerator) + "/" + String.valueOf(denominator);
    }
    
    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
    */



    // Most voted solution: Regex
    // The (?=) part is a zero-width positive lookahead. Since [-,+] means - or +, 
    // the regex (?=[-,+]) means the next element is either - or +.
    // Since | is logical or operator, "/|(?=[-+])" means the element is "/", 
    // or the next element is either - or +. For example, when expression = "-1/2+1/2-1/3", 
    // generates [-1, 2, +1, 2, -1, 3 ]. Note that the signs - and + are preserved.
    public String fractionAddition(String expression) {
        int A = 0, B = 1;
        String[] S = expression.split("/|(?=[-+])");
        for (int i = 0; i < S.length; i += 2) {
            int a = Integer.valueOf(S[i]);
            int b = Integer.valueOf(S[i + 1]);
            A = A * b + a * B;
            B *= b;
            int g = gcd(Math.abs(A), B);
            A /= g;
            B /= g;
        }
        return A + "/" + B;
    }

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }



    // Standard solution
    /*
    public String fractionAddition(String expression) {
        List < Character > sign = new ArrayList < > ();
        if (expression.charAt(0) != '-')
            sign.add('+');
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-')
                sign.add(expression.charAt(i));
        }
        int prev_num = 0, prev_den = 1, i = 0;
        for (String sub: expression.split("(\\+)|(-)")) {
            if (sub.length() > 0) {
                String[] fraction = sub.split("/");
                int num = (Integer.parseInt(fraction[0]));
                int den = (Integer.parseInt(fraction[1]));
                int g = Math.abs(gcd(den, prev_den));
                if (sign.get(i++) == '+')
                    prev_num = prev_num * den / g + num * prev_den / g;
                else
                    prev_num = prev_num * den / g - num * prev_den / g;
                prev_den = den * prev_den / g;
                g = Math.abs(gcd(prev_den, prev_num));
                prev_num /= g;
                prev_den /= g;
            }
        }
        return prev_num + "/" + prev_den;
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    */
}
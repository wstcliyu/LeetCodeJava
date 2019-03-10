public class Solve_640 {
	// My first solution

	public String solveEquation(String equation) {
        int[] left = parseEquation(equation, 0);
        int[] right = parseEquation(equation, left[2] + 1);
        int countX = left[0] - right[0];
        int constant = right[1] - left[1];
        if (countX == 0) 
            return constant == 0 ? "Infinite solutions" : "No solution";
        else 
            return "x=" + constant/countX;
    }
    
    private int[] parseEquation(String equation, int start) {
        int i;
        int sign = 1;
        int coefficient = 0;
        int constant = 0;
        StringBuilder sb = new StringBuilder();
        for (i = start; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (c == '=') {
                break;
            } else if (c == '+' || c == '-') {
                if (sb.length() > 0) {
                    constant += sign * Integer.valueOf(sb.toString());
                    sb = new StringBuilder();
                }
                sign = c == '-' ? -1 : 1;
            } else if (c == 'x') {
            	// Corner Case 1: If there is no coeffient for x, then we take it as 1
                if (sb.length() == 0) 
                	coefficient += sign;
                else
                	coefficient += sign * Integer.valueOf(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        
        // Corner Case 2: If sb is not empty, we should add it to constant
        if (sb.length() > 0)
            constant += sign * Integer.valueOf(sb.toString());
        
        return new int[]{coefficient, constant, i};
    }



    // Standard solution #1
    /*
    public List < String > breakIt(String s) {
        List < String > res = new ArrayList < > ();
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (r.length() > 0)
                    res.add(r);
                r = "" + s.charAt(i);
            } else
                r += s.charAt(i);
        }
        res.add(r);
        return res;
    }

    public String coeff(String x) {
        if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9')
            return x.replace("x", "");
        return x.replace("x", "1");
    }

    public String solveEquation(String equation) {
        String[] lr = equation.split("=");
        int lhs = 0, rhs = 0;
        for (String x: breakIt(lr[0])) {
            if (x.indexOf("x") >= 0) {
                lhs += Integer.parseInt(coeff(x));
            } else
                rhs -= Integer.parseInt(x);
        }
        for (String x: breakIt(lr[1])) {
            if (x.indexOf("x") >= 0)
                lhs -= Integer.parseInt(coeff(x));
            else
                rhs += Integer.parseInt(x);
        }
        if (lhs == 0) {
            if (rhs == 0)
                return "Infinite solutions";
            else
                return "No solution";
        }
        return "x=" + rhs / lhs;
    }
    */
}
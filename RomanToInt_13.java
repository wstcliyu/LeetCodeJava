public class RomanToInt_13 {
    // Most voted solution
    public static int romanToInt(String s) {
        int sum = 0;
        if(s.contains("IV")) sum-=2;
        if(s.contains("IX")) sum-=2;
        if(s.contains("XL")) sum-=20;
        if(s.contains("XC")) sum-=20;
        if(s.contains("CD")) sum-=200;
        if(s.contains("CM")) sum-=200;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I' : sum += 1; break;
                case 'V' : sum += 5; break;
                case 'X' : sum += 10; break;
                case 'L' : sum += 50; break;
                case 'C' : sum += 100; break;
                case 'D' : sum += 500; break;
                case 'M' : sum += 1000; break;
            }
        }
        
        return sum;
    }


    // My first solution
    /*
    public static int romanToInt(String s) {
        int n = s.length();
        int result = 0;
        for (int i=0; i<n; i++) {
            char c1 = s.charAt(i);
            result += getNum(c1);
            if (i == n-1)
                break;
            char c2 = s.charAt(i+1);
            if (c1 == 'C' && (c2 == 'D' || c2 == 'M'))
                result -= 2*getNum(c1);
            if (c1 == 'X' && (c2 == 'L' || c2 == 'C'))
                result -= 2*getNum(c1);
            if (c1 == 'I' && (c2 == 'V' || c2 == 'X'))
                result -= 2*getNum(c1);
        }
        return result;
    }
    public static int getNum(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
    */


    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println("Output should be 1994");
    }
}

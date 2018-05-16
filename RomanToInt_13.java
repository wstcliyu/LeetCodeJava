public class RomanToInt_13 {
    public static int romanToInt(String s) {
        /* Most voted solution
        int sum=0;
        if(s.indexOf("IV")!=-1){sum-=2;}
        if(s.indexOf("IX")!=-1){sum-=2;}
        if(s.indexOf("XL")!=-1){sum-=20;}
        if(s.indexOf("XC")!=-1){sum-=20;}
        if(s.indexOf("CD")!=-1){sum-=200;}
        if(s.indexOf("CM")!=-1){sum-=200;}

        char c[]=s.toCharArray();
        int count=0;
        for(;count<=s.length()-1;count++) {
            if (c[count] == 'M') sum += 1000;
            if (c[count] == 'D') sum += 500;
            if (c[count] == 'C') sum += 100;
            if (c[count] == 'L') sum += 50;
            if (c[count] == 'X') sum += 10;
            if (c[count] == 'V') sum += 5;
            if (c[count] == 'I') sum += 1;
        }
        return sum;
        */

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
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println("Output should be 1994");
    }
}

public class Student_551 {
    // Most voted solution
    public boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }


    // Good solution
    /*
    public boolean checkRecord(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }
    */


    // My solution
    /*
    public boolean checkRecord(String s) {
        int countA = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'A')
                countA++;
            if (countA > 1)
                return false;
            if (i > 1 && s.charAt(i) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L')
                return false;
        }
        return true;
    }
    */
}

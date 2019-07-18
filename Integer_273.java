class Integer_273 {
    // My first solution
    String[] digit1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] digit2 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] digit3 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = helper(num % 1000);
        for (int i = 0; i < 3; i++) {
            String tmp = "";
            switch (i) {
                case 0: tmp = " Thousand"; break;
                case 1: tmp = " Million"; break;
                case 2: tmp = " Billion"; break;
            }
            if (num >= 1000) {
                num /= 1000;
                String prefix = helper(num % 1000);
                // Corner case: 1000000 -> "One Million"
                if (!prefix.isEmpty())
                    res = prefix + tmp + (res.isEmpty() ? "" : " " + res);
            }
        }
        return res;
    }
    
    private String helper(int num) {
        String res = "";
        
        if (num / 100 > 0) {
            res = digit1[num / 100] + " Hundred ";
        }
        
        num %= 100;
        if (num == 0) {
            // Corner case: 0 -> res == "", 100 -> res = "One Hundred "
            return res.isEmpty() ? res : res.substring(0, res.length() - 1);
        } else if (num >= 20) {
            int tens = num / 10;
            res += digit3[tens];
            int ones = num % 10;
            return ones == 0 ? res : res + " " + digit1[ones];
        } else if (num < 10) {
            int ones = num % 10;
            return res + digit1[ones];
        } else {
            return res + digit2[num - 10];
        }
    }
}
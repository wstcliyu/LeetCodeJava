class Day_1154 {
	int[] days = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        String[] digits = date.split("-");
        int year = Integer.valueOf(digits[0]);
        int month = Integer.valueOf(digits[1]);
        int day = Integer.valueOf(digits[2]);
        int res = day;
        for (int i = 1; i < month; i++) {
        	res += days[i];
        }
        if (isLeapYear(year) && month > 2) res++;
        return res;
    }

    private boolean isLeapYear(int year) {
    	return (year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }
}
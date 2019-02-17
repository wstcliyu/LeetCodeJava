public class Long_925 {
	public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        int m = name.length(), n = typed.length();
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) != typed.charAt(j))
                return false;
            int s1 = i, s2 = j;
            do {
                i++;
            } while (i < m && name.charAt(i) == name.charAt(i - 1));
            do {
                j++;
            } while (j < n && typed.charAt(j) == typed.charAt(j - 1));
            if (i - s1 > j - s2) 
                return false;
        }
        return i == m && j == n;
    }
}
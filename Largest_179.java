class Largest_179 {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        // Much slower
        /*
        Arrays.sort(strs, (s1, s2) -> {
            String a = s1 + s2;
            String b = s2 + s1;
            return b.compareTo(a);
        });
        */
        
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        };
        
        Arrays.sort(strs, comp);

        if (strs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s);
        return sb.toString();
    }
}